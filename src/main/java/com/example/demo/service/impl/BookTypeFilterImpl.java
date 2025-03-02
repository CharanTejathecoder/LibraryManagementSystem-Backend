package com.example.demo.service.impl;

import com.example.demo.dto.BookFilterResponse;
import com.example.demo.enumeration.Operator;
import com.example.demo.service.BookFilterStratergy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookTypeFilterImpl implements BookFilterStratergy {
    @Override
    public List<BookFilterResponse> getFilteredBook(Operator operator, String value) {
        return List.of();
    }
}
