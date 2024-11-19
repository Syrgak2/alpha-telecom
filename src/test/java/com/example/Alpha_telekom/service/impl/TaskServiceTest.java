package com.example.Alpha_telekom.service.impl;

import com.example.Alpha_telekom.constants.Constants;
import com.example.Alpha_telekom.dto.task.TaskDto;
import com.example.Alpha_telekom.dto.task.TasksDto;
import com.example.Alpha_telekom.entity.Task;
import com.example.Alpha_telekom.exceptions.NotFoundException;
import com.example.Alpha_telekom.repository.TaskRepository;
import com.example.Alpha_telekom.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskServiceImpl taskService;


    @Test
    void saveTask() {
//        When
        when(taskRepository.save(any())).thenReturn(Constants.TASK1);
        TaskDto expected = taskService.saveTask(Constants.CREATE_TASK_DTO);

//        Then
        TaskDto actual = Constants.TASK_DTO;
        assert expected.equals(actual);
    }


    @Test
    void getTaskById() {
//        When
        when(taskRepository.findById(Constants.TASK1.getId())).thenReturn(Optional.ofNullable(Constants.TASK1));
        TaskDto expected = taskService.getTaskById(Constants.TASK1.getId());

//        Then
        TaskDto actual = Constants.TASK_DTO;
        assert expected.equals(actual);
    }


    @Test
    void updateTask() {
//        When
        when(taskRepository.findById(Constants.TASK1.getId())).thenReturn(Optional.ofNullable(Constants.TASK1));
        when(taskRepository.save(any())).thenReturn(Constants.TASK1);
        TaskDto expected = taskService.updateTask(Constants.TASK1.getId(), Constants.CREATE_TASK_DTO);

//        Then
        TaskDto actual = Constants.TASK_DTO;
        assert expected.equals(actual);
    }


    @Test
    void deleteTask() {
//        When
        when(taskRepository.findById(Constants.TASK1.getId())).thenReturn(Optional.ofNullable(Constants.TASK1));
        taskService.deleteTask(Constants.TASK1.getId());
    }


    @Test
    void whenNotFound() {
//        When
        when(taskRepository.findById(Constants.TASK1.getId())).thenReturn(Optional.empty());

        assertThrows(
                NotFoundException.class,
                () -> taskService.deleteTask(Constants.TASK1.getId())
        );

        assertThrows(
                NotFoundException.class,
                () -> taskService.getTaskById(Constants.TASK1.getId())
        );

        assertThrows(
                NotFoundException.class,
                () -> taskService.updateTask(Constants.TASK1.getId(), Constants.CREATE_TASK_DTO));

    }




}
