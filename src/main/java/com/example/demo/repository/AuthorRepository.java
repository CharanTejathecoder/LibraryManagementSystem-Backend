package com.example.demo.repository;

import com.example.demo.model.Author;
import com.example.demo.model.AuthorCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, AuthorCompositeKey> {
    List<Author> findByName(String name);
    List<Author> findByNameContains(String name);

    Author findByEmail(String email);
}
