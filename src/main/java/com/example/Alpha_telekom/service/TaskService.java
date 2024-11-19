package com.example.Alpha_telekom.service;

import com.example.Alpha_telekom.dto.task.CreateOrUpdateTaskDto;
import com.example.Alpha_telekom.dto.task.TaskDto;
import com.example.Alpha_telekom.dto.task.TasksDto;


import java.util.List;

public interface TaskService {

    TaskDto saveTask(CreateOrUpdateTaskDto createOrUpdateTask);
    TasksDto getAllTasks();
    void deleteTask(Long taskId);
    TaskDto getTaskById(Long taskId);
    TaskDto updateTask(Long taskId, CreateOrUpdateTaskDto updateTask);

}
