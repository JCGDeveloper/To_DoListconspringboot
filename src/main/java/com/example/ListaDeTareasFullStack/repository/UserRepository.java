package com.example.ListaDeTareasFullStack.repository;

import com.example.ListaDeTareasFullStack.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE username = :username AND password = :password", nativeQuery = true)
    Optional<UserEntity> findByUsernameAndPasswordNative(@Param("username") String username, @Param("password") String password);

}
