package com.example.Alpha_telekom.constants;

import com.example.Alpha_telekom.dto.task.CreateOrUpdateTaskDto;
import com.example.Alpha_telekom.dto.task.TaskDto;
import com.example.Alpha_telekom.dto.task.TasksDto;
import com.example.Alpha_telekom.dto.user.UserDto;
import com.example.Alpha_telekom.entity.MyUser;
import com.example.Alpha_telekom.entity.Task;

import java.time.LocalDate;
import java.util.List;

public class Constants {
    public static LocalDate LOCAL_DATE = LocalDate.of(2021, 1, 1);
    public static UserDto USER_DTO = new UserDto("Test", "Test", 1L);
    public static MyUser USER1 = new MyUser(1L, "Test", "Test");

    public static Task TASK1 = new Task(1L, "Task 1", "Description 1", LOCAL_DATE, "OPEN", "LOW", null, null);
    public static CreateOrUpdateTaskDto CREATE_TASK_DTO = new CreateOrUpdateTaskDto("Task 1", "Description 1", LOCAL_DATE, "OPEN", "LOW", null);
    public static TaskDto TASK_DTO = new TaskDto(1L, "Task 1", "Description 1",  LOCAL_DATE, "OPEN", "LOW");

    public static List<Task> TASKS = List.of(TASK1);
    public static List<TaskDto> ListTASK_DTO = List.of(TASK_DTO);

    public static TasksDto TASKS_DTO = new TasksDto(TASKS.size(), ListTASK_DTO);




}
