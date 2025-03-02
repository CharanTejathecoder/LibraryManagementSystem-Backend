package com.example.demo.service;

import com.example.demo.dto.TxnRequest;
import com.example.demo.enumeration.TxnStatus;
import com.example.demo.exception.BookException;
import com.example.demo.exception.UserException;
import com.example.demo.model.Book;
import com.example.demo.model.Txn;
import com.example.demo.model.User;
import com.example.demo.repository.TxnRepository;
import com.example.demo.service.impl.BookService;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TxnService {
    @Autowired
    private TxnRepository txnRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Transactional(rollbackFor = {UserException.class,BookException.class})
    public String create(TxnRequest txnRequest) throws UserException, BookException {
        User user = userService.checkUserValidOrNot(txnRequest.getUserEmail());
        if(user==null)
        {
            throw new UserException("user not found");
        }

        Book book = bookService.checkBookExistsOrNot(txnRequest.getBookNo());
        if(book==null)
        {
            throw new BookException("Book not found");
        }

        if(book.getUser()!=null)
        {
            throw new BookException("Book cannot be assigned!");
        }
        Txn txn = Txn.builder().
                txn_id(UUID.randomUUID().toString()).
                txnStatus(TxnStatus.ISSUED).
                book(book).
                user(user)
                .build();
        bookService.assign(book,user);
        txnRepository.save(txn);
        return txn.getTxn_id();
    }
}
