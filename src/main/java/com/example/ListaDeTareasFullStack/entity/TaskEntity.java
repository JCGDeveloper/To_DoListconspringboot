package com.example.ListaDeTareasFullStack.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(unique = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  UserEntity user;
}
