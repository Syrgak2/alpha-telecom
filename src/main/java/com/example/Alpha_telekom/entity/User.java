package com.example.Alpha_telekom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
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

    public User() {
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, Long id) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Task> getCreatedTask() {
        return createdTask;
    }

    public void setCreatedTask(Collection<Task> createdTask) {
        this.createdTask = createdTask;
    }

    public Collection<Task> getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(Collection<Task> assignedTask) {
        this.assignedTask = assignedTask;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
