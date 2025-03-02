package com.example.demo.service;

import com.example.demo.dto.TxnRequest;
import com.example.demo.repository.TxnRepository;
import com.example.demo.service.impl.BookService;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TxnService {
    @Autowired
    private TxnRepository txnRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public String create(TxnRequest txnRequest) {
        return null;
    }
}
