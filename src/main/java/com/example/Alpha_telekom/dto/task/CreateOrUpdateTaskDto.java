package com.example.Alpha_telekom.dto.task;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateOrUpdateTaskDto {

    private String title;
    private String description;
    private LocalDate deadline;
    private String status;
    private String priority;
    private Long assignedToId;

    public CreateOrUpdateTaskDto(String title, String description, LocalDate deadline, String status, String priority, Long assignedToId) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.priority = priority;
        this.assignedToId = assignedToId;
    }

}
