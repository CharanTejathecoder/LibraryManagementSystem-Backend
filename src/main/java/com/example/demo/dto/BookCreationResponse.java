package com.example.demo.dto;

import com.example.demo.enumeration.BookType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookCreationResponse {
    private String title;
    private String bookNo;
}
