package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthorByEmail(String email)
    {
        return authorRepository.findByEmail(email);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
}
