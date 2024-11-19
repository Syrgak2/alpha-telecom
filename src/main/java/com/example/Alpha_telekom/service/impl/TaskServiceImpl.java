package com.example.Alpha_telekom.service.impl;


import com.example.Alpha_telekom.dto.task.CreateOrUpdateTaskDto;
import com.example.Alpha_telekom.dto.task.TaskDto;
import com.example.Alpha_telekom.dto.task.TasksDto;
import com.example.Alpha_telekom.entity.MyUser;
import com.example.Alpha_telekom.entity.Task;
import com.example.Alpha_telekom.exceptions.NotFoundException;
import com.example.Alpha_telekom.integrations.SendEmail;
import com.example.Alpha_telekom.mapper.TaskMapper;
import com.example.Alpha_telekom.repository.TaskRepository;
import com.example.Alpha_telekom.service.TaskService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final SendEmail sendEmail;

    private TaskMapper taskMapper = new TaskMapper();

    public TaskServiceImpl(TaskRepository taskRepository, SendEmail sendEmail) {
        this.sendEmail = sendEmail;
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDto saveTask(CreateOrUpdateTaskDto createOrUpdateTaskDto) {
        Task task = taskMapper.mapToTask(createOrUpdateTaskDto);
        if (task== null) {
            throw new NotFoundException("Task is null");
        }

        MyUser assignedUser = task.getAssignedTo();
        if (assignedUser != null && assignedUser.getEmail() != null) {
            sendEmail.sendEmail(assignedUser.getEmail(), "New Task", "You have a new task: " + task.getTitle());
        }
        Task savedTask = taskRepository.save(task);
        return taskMapper.mapToTaskDto(savedTask);
    }

    @Override
    @Cacheable(value = "tasks")
    public TasksDto getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        simulateSlowService();
        return taskMapper.mapToTasksDto(tasks.size(), tasks);
    }
    private void simulateSlowService() {
        try {
            Thread.sleep(3000); // Симуляция долгого выполнения
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException("Task not found"));
        taskRepository.delete(task);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException("Task not found"));

        return taskMapper.mapToTaskDto(task);
    }

    @Override
    public TaskDto updateTask(Long taskId, CreateOrUpdateTaskDto updateTask) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException("Task not found"));
        task.setTitle(updateTask.getTitle());
        task.setDescription(updateTask.getDescription());
        task.setDeadline(updateTask.getDeadline());
        task.setStatus(updateTask.getStatus());
        task.setPriority(updateTask.getPriority());
        return taskMapper.mapToTaskDto(taskRepository.save(task));
    }
}
