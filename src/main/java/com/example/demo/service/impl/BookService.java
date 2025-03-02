package com.example.demo.service.impl;

import com.example.demo.dto.BookCreationRequest;
import com.example.demo.dto.BookCreationResponse;
import com.example.demo.dto.BookFilterResponse;
import com.example.demo.enumeration.BookFilter;
import com.example.demo.enumeration.Operator;
import com.example.demo.model.Author;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookFilterFactory;
import com.example.demo.service.BookFilterStratergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Book;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookFilterFactory bookFilterFactory;

    public BookCreationResponse addBook(BookCreationRequest request){
        Author authorFromDB= authorService.findAuthorByEmail(request.getAuthorEmail());
        if(authorFromDB == null)
        {
            authorFromDB= Author.builder().
                    name(request.getAuthorName()).
                    email(request.getAuthorEmail()).
                    id(UUID.randomUUID().toString()).build();

        }
        Book book= request.toBook();
        book.setAuthor(authorFromDB);
        book=bookRepository.save(book);
        return BookCreationResponse.builder().bookNo(book.getBookNo()).title(book.getTitle()).build();
    }

    public List<BookFilterResponse> filter(BookFilter filterBy, Operator operator, String value){
        BookFilterStratergy bookFilterStratergy = bookFilterFactory.getStratergy(filterBy);
        return bookFilterStratergy.getFilteredBook(operator,value);
    }
}
