package com.example.ListaDeTareasFullStack.controller;

import com.example.ListaDeTareasFullStack.entity.UserEntity;
import com.example.ListaDeTareasFullStack.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(path = "users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity user) {
        return userService.registrarUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}


