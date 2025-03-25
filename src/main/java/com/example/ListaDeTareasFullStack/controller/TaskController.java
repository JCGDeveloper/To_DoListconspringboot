package com.example.ListaDeTareasFullStack.controller;

import com.example.ListaDeTareasFullStack.entity.TaskEntity;
import com.example.ListaDeTareasFullStack.entity.UserEntity;
import com.example.ListaDeTareasFullStack.service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/user/{userId}")
    public List<TaskEntity> getTasksByUser(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }

    @GetMapping("/{id}")
    public Optional<TaskEntity> getTaskById(@PathVariable long id){
        return  taskService.getTaskById(id);
    }

    @PostMapping("/{userId}")
    public TaskEntity saveTask(@RequestBody TaskEntity task, @PathVariable Long userId) {
        return taskService.saveTaskWithUser(task, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteTask (@PathVariable long id){
        taskService.deleteTask(id);
    }



}
