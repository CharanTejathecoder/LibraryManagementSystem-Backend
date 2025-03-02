package com.example.demo.service.impl;

import com.example.demo.dto.BookFilterResponse;
import com.example.demo.enumeration.Operator;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookFilterStratergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookNoFilterImpl implements BookFilterStratergy {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookFilterResponse> getFilteredBook(Operator operator, String value) {
        if(!operator.equals(Operator.EQUAL)){
            throw new IllegalArgumentException("Only Equals is expected with Book number");
        }

        List<Book> booksFromDb= bookRepository.findByBookNo(value);
        return booksFromDb.
                stream().
                map(book -> convertIntoBookFilterResponse(book)).
                collect(Collectors.toList());
    }

    private BookFilterResponse convertIntoBookFilterResponse(Book book) {
        String userName = (book.getUser() != null) ? book.getUser().getName() : null;
        String authorName = (book.getAuthor() != null) ? book.getAuthor().getName() : null;
        String authorEmail = (book.getAuthor() != null) ? book.getAuthor().getEmail() : null;

        return BookFilterResponse.builder()
                .bookNo(book.getBookNo())
                .title(book.getTitle())
                .bookType(book.getBookType())
                .securityAmount(book.getSecurityAmount())
                .user_name(userName)
                .author_name(authorName)
                .author_email(authorEmail)
                .build();
    }

}
