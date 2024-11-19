package com.example.Alpha_telekom.mapper;

import com.example.Alpha_telekom.dto.task.CreateOrUpdateTaskDto;
import com.example.Alpha_telekom.dto.task.TaskDto;
import com.example.Alpha_telekom.dto.task.TasksDto;
import com.example.Alpha_telekom.entity.Task;

import java.util.List;

public class TaskMapper {

    public TaskDto mapToTaskDto(Task task) {
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getDeadline(), task.getStatus(), task.getPriority());
    }

    public TasksDto mapToTasksDto(int count, List<Task> tasks) {
        return new TasksDto(count, tasks.stream().map(this::mapToTaskDto).toList());
    }

    public Task mapToTask(CreateOrUpdateTaskDto createOrUpdateTaskDto) {
        return new Task(createOrUpdateTaskDto.getTitle(), createOrUpdateTaskDto.getDescription(), createOrUpdateTaskDto.getDeadline(), createOrUpdateTaskDto.getStatus(), createOrUpdateTaskDto.getPriority());
    }
}
