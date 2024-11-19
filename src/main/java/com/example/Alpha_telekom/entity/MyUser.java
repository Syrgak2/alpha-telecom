package com.example.Alpha_telekom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

@Entity
@Data
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;
    private String email;
    @NotNull
    private String password;
    @OneToMany
    @JoinColumn(name = "created_by_id")
    @JsonIgnore
    private Collection<Task> createdTask;

    @OneToMany
    @JoinColumn(name = "assigned_to_id")
    @JsonIgnore
    private Collection<Task> assignedTask;

    public MyUser() {
    }

    public MyUser(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public MyUser(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public MyUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
