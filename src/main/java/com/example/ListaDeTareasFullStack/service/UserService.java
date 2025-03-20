package com.example.ListaDeTareasFullStack.service;

import com.example.ListaDeTareasFullStack.entity.UserEntity;
import com.example.ListaDeTareasFullStack.repository.UserRepository;
import org.springframework.stereotype.Service;

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

    public Optional<UserEntity> getUserById(long id){
        return  userRepository.findById(id);
    }

    public UserEntity saveUser(UserEntity user){
        return  userRepository.save(user);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
