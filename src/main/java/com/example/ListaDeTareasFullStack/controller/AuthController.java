package com.example.ListaDeTareasFullStack.controller;

import com.example.ListaDeTareasFullStack.entity.UserEntity;
import com.example.ListaDeTareasFullStack.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/api/login")
    public Optional<UserEntity> loginUser(@RequestBody UserEntity user) {
        try{
            Optional<UserEntity> usuario = userService.verificarCredenciales(user.getUsername(), user.getPassword());
            if (usuario.isPresent()) {
                System.out.println("Received userId: " + usuario.get().getId());
                return usuario; // Aquí puedes devolver un mensaje o redirigir al frontend
            }else {
                throw new RuntimeException("Credenciales incorrectas");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
