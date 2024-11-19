package com.example.Alpha_telekom.dto.task;

import com.example.Alpha_telekom.dto.user.UserDto;

public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String deadline;
    private String status;
    private String priority;
    private UserDto createdBy;
    private UserDto assignedTo;

    public TaskDto(Long id, String title, String description, String deadline, String status, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public UserDto getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDto createdBy) {
        this.createdBy = createdBy;
    }

    public UserDto getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserDto assignedTo) {
        this.assignedTo = assignedTo;
    }
}
