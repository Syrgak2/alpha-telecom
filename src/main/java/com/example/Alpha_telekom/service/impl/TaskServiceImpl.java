package com.example.Alpha_telekom.service.impl;


import com.example.Alpha_telekom.dto.task.CreateOrUpdateTaskDto;
import com.example.Alpha_telekom.dto.task.TaskDto;
import com.example.Alpha_telekom.dto.task.TasksDto;
import com.example.Alpha_telekom.entity.Task;
import com.example.Alpha_telekom.exceptions.NotFoundException;
import com.example.Alpha_telekom.mapper.TaskMapper;
import com.example.Alpha_telekom.repository.TaskRepository;
import com.example.Alpha_telekom.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private TaskMapper taskMapper = new TaskMapper();

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public TaskDto saveTask(CreateOrUpdateTaskDto createOrUpdateTaskDto) {
        Task task = taskMapper.mapToTask(createOrUpdateTaskDto);
        if (task== null) {
            throw new NotFoundException("Task is null");
        }
        Task savedTask = taskRepository.save(task);
        return taskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TasksDto getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.mapToTasksDto(tasks.size(), tasks);
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
