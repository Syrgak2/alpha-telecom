package com.example.Alpha_telekom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;
    private String description;
    private LocalDate deadline;
    private String status;
    private String priority;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private MyUser createdBy;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private MyUser assignedTo;

    public Task() {

    }

    public Task(Long id, String title, String description, LocalDate deadline, String status, String priority, MyUser createdBy, MyUser assignedTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.priority = priority;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
    }

    public Task( String title, String description, LocalDate deadline, String status, String priority) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.priority = priority;
    }

    public Task(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


}
