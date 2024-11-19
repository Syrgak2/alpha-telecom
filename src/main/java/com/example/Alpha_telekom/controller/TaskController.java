package com.example.Alpha_telekom.controller;

import com.example.Alpha_telekom.dto.task.CreateOrUpdateTaskDto;
import com.example.Alpha_telekom.dto.task.TaskDto;
import com.example.Alpha_telekom.entity.Task;
import com.example.Alpha_telekom.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(
            summary = "Create a new task",
            description = "This endpoint creates a new task and returns the created task.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully created task",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid task data",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content
                    )
            }
    )
    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(@RequestPart("task") CreateOrUpdateTaskDto task) {
        if (task == null) {
            log.error("Task is null");
            return ResponseEntity.badRequest().build();
        }
        try {
            return ResponseEntity.ok(taskService.saveTask(task));
        } catch (Exception e) {
            log.error("Error saving task", e);
            return ResponseEntity.internalServerError().build();
        }

    }

    @Operation(
            summary = "Get task by ID",
            description = "This endpoint retrieves a task by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved task",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Task not found",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content
                    )
            }
    )
    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("taskId") Long taskId) {
        try {
            return ResponseEntity.ok(taskService.getTaskById(taskId));
        } catch (Exception e) {
            log.error("Error getting task by id", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(
            summary = "Get all tasks",
            description = "This endpoint retrieves all tasks.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved tasks",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content
                    )
            }
    )
    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        try {
            return ResponseEntity.ok(taskService.getAllTasks());
        } catch (Exception e) {
            log.error("Error getting all tasks", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(
            summary = "Delete a task",
            description = "This endpoint deletes a task by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Task successfully deleted",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Task not found",
                            content = @Content
                    )
            }
    )
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") Long taskId) {
        try {
            taskService.deleteTask(taskId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error deleting task", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(
            summary = "Обновить задачу",
            description = "Обновляет существующую задачу по идентификатору"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Задача успешно обновлена",
                    content = @Content(schema = @Schema(implementation = TaskDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Некорректные данные запроса",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Внутренняя ошибка сервера",
                    content = @Content
            )
    })
    @PatchMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("taskId") Long taskId, @RequestPart("task") CreateOrUpdateTaskDto task) {
        try {
            return ResponseEntity.ok(taskService.updateTask(taskId, task));
        } catch (Exception e) {
            log.error("Error updating task", e);
            return ResponseEntity.internalServerError().build();
        }
    }




}
