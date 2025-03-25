package com.example.ListaDeTareasFullStack.service;

import com.example.ListaDeTareasFullStack.entity.TaskEntity;
import com.example.ListaDeTareasFullStack.entity.UserEntity;
import com.example.ListaDeTareasFullStack.repository.TaskRepository;
import com.example.ListaDeTareasFullStack.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository , UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskEntity> getAllTask(){
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> getTaskById(long id){
        return  taskRepository.findById(id);
    }

    public TaskEntity saveTask(TaskEntity task){
        return taskRepository.save(task);
    }

    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }


    public List<TaskEntity> getTasksByUser(UserEntity user) {
        return taskRepository.findByUser(user);
    }

    public TaskEntity saveTaskWithUser(TaskEntity task, Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        task.setUser(user); // Asociar la tarea al usuario
        return taskRepository.save(task);
    }

    public List<TaskEntity> getTasksByUser(long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return taskRepository.findByUser(user);
    }
}
