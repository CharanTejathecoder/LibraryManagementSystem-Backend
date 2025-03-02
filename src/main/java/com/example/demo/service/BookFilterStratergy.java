package com.example.demo.service;

import com.example.demo.dto.BookFilterResponse;
import com.example.demo.enumeration.Operator;

import java.util.List;

public interface BookFilterStratergy {
    List<BookFilterResponse> getFilteredBook(Operator operator, String value);
}
