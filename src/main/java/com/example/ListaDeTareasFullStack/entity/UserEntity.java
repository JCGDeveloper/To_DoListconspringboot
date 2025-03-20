package com.example.ListaDeTareasFullStack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<TaskEntity> taskes;
}
