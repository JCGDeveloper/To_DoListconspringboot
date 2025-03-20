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

    //asignar el user a la tarea
    public TaskEntity asignUserToTask(long userid, long taskid){
        //Buscamos el usuario por su id
        UserEntity user = userRepository.findById(userid).orElseThrow(()->new RuntimeException("No se ha encontrado el usuario que has seleccionado"));

        //Buscamos la tarea por su id
        TaskEntity task = taskRepository.findById(taskid).orElseThrow(()->new RuntimeException("No se ha encontrado la tarea que has seleccionado"));

        task.setUser(user);
        user.getTaskes().add(task);

        return taskRepository.save(task);
    }
}
