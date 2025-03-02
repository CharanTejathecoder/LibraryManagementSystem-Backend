package com.example.demo.repository;

import com.example.demo.enumeration.BookType;
import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitle(String title);
    List<Book> findByTitleContains(String title);
    List<Book> findByBookNo(String bookNo);
    List<Book> findByBookType(BookType bookType);

}
