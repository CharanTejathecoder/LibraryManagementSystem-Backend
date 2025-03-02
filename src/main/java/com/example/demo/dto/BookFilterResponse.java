package com.example.demo.dto;

import com.example.demo.enumeration.BookType;
import com.example.demo.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookFilterResponse {
    private String title;
    private String bookNo;
    private BookType bookType;
    private Double securityAmount;
    private String user_name;
    private String author_name;
    private String author_email;
}
