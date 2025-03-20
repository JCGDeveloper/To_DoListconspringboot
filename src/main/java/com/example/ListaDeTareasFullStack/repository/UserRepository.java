package com.example.ListaDeTareasFullStack.repository;

import com.example.ListaDeTareasFullStack.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity,Long> {
}
