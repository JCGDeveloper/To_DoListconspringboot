package com.example.ListaDeTareasFullStack.controller;

import com.example.ListaDeTareasFullStack.entity.TaskEntity;
import com.example.ListaDeTareasFullStack.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tasks")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskEntity> getAllTasks(){
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public Optional<TaskEntity> getTaskById(@PathVariable long id){
        return  taskService.getTaskById(id);
    }

    @PostMapping
    public TaskEntity saveTask(@RequestBody TaskEntity task){
        return  taskService.saveTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask (@PathVariable long id){
        taskService.deleteTask(id);
    }


    @PutMapping("/{userId}/assign/{taskId}")
    public TaskEntity asignUserToTask(@PathVariable long userId , @PathVariable long taskId){
        return taskService.asignUserToTask(userId,taskId);
    }
}
