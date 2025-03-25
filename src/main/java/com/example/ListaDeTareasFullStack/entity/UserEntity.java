package com.example.ListaDeTareasFullStack.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<TaskEntity> tasks;
}
