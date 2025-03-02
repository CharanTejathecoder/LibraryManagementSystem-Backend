package com.example.demo.controller;

import com.example.demo.dto.BookCreationRequest;
import com.example.demo.dto.BookCreationResponse;
import com.example.demo.dto.BookFilterResponse;
import com.example.demo.enumeration.BookFilter;
import com.example.demo.enumeration.Operator;
import com.example.demo.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public BookCreationResponse addBook(@RequestBody BookCreationRequest request){
        return bookService.addBook(request);
    }

    @GetMapping("/filter")
    public List<BookFilterResponse> filteredBook(@RequestParam BookFilter filterBy,
                                                 @RequestParam Operator operator,
                                                 @RequestParam String value) {
        return bookService.filter(filterBy, operator,value);
    }
}
