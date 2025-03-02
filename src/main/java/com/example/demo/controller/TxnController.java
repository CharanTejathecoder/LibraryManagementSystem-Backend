package com.example.demo.controller;

import com.example.demo.dto.TxnRequest;
import com.example.demo.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/txn")
@Validated
public class TxnController {
    @Autowired
    private TxnService txnService;

    @PostMapping("/issue")
    public String createTxn(@RequestBody TxnRequest txnRequest){
        return txnService.create(txnRequest);
    }

}
