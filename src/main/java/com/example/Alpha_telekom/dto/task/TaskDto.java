package com.example.Alpha_telekom.dto.task;

import com.example.Alpha_telekom.dto.user.UserDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;
    private String status;
    private String priority;
    private UserDto createdBy;
    private UserDto assignedTo;

    public TaskDto(Long id, String title, String description, LocalDate deadline, String status, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.priority = priority;
    }
}
