package com.example.demo.service;

import com.example.demo.dto.BookFilterResponse;
import com.example.demo.enumeration.BookFilter;
import com.example.demo.enumeration.BookType;
import com.example.demo.enumeration.Operator;
import com.example.demo.service.impl.BookNoFilterImpl;
import com.example.demo.service.impl.BookTitleFilterImpl;
import com.example.demo.service.impl.BookTypeFilterImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookFilterFactory {
    private final Map<BookFilter, BookFilterStratergy> stratergies = new HashMap<>();

    public BookFilterFactory(BookNoFilterImpl bookNoFilter, BookTitleFilterImpl bookTitleFilter, BookTypeFilterImpl bookTypeFilter){
        stratergies.put(BookFilter.BOOK_NO, bookNoFilter);
        stratergies.put(BookFilter.BOOK_TITLE, bookTitleFilter);
        stratergies.put(BookFilter.BOOK_TYPE, bookTypeFilter);
    };

    public BookFilterStratergy getStratergy(BookFilter filter){
        return stratergies.get(filter);
    }
}
