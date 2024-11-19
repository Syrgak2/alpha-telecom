package com.example.Alpha_telekom.dto.task;

import java.util.List;

public class TasksDto {
    private int count;
    private List<TaskDto> tasks;

    public TasksDto(int count, List<TaskDto> tasks) {
        this.count = count;
        this.tasks = tasks;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }
}
