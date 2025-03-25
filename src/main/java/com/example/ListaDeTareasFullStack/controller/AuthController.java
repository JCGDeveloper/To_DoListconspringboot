package com.example.ListaDeTareasFullStack.controller;

import com.example.ListaDeTareasFullStack.entity.UserEntity;
import com.example.ListaDeTareasFullStack.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/api/login")
    public ResponseEntity<?> loginUser(@RequestBody UserEntity user) {
        try {
            Optional<UserEntity> usuario = userService.verificarCredenciales(user.getUsername(), user.getPassword());
            if (usuario.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                response.put("id", usuario.get().getId());
                response.put("username", usuario.get().getUsername());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(401).body("Credenciales incorrectas");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error en el servidor: " + e.getMessage());
        }
    }
}
