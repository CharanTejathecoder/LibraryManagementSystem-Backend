package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByName(String value);
    List<User> findByNameContains(String value);
    List<User> findByEmail(String value);
    List<User> findByEmailContains(String value);
    List<User> findByPhoneNo(String value);
    List<User> findByPhoneNoContains(String value);

}
