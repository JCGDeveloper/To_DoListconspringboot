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
        try {
            UserEntity user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Usuario con ID " + userId + " no encontrado"));
            task.setUser(user);
            return taskRepository.save(task);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la tarea: " + e.getMessage());
        }
    }

    public List<TaskEntity> getTasksByUser(long userId) {
        try {
            UserEntity user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Usuario con ID " + userId + " no encontrado"));
            return taskRepository.findByUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las tareas del usuario: " + e.getMessage());
        }
    }
}
