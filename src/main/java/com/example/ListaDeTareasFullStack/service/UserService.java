package com.example.ListaDeTareasFullStack.service;

import com.example.ListaDeTareasFullStack.entity.UserEntity;
import com.example.ListaDeTareasFullStack.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Metodos

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id){
        return  userRepository.findById(id);
    }

    public UserEntity registrarUser(UserEntity user){
        return  userRepository.save(user);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    public Optional<UserEntity> verificarCredenciales(String username, String password ) {
        Optional<UserEntity> usuarioExistente = userRepository.findByUsernameAndPasswordNative(username,password);
        return usuarioExistente;

    }



}
