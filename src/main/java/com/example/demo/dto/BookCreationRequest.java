package com.example.demo.dto;

import com.example.demo.enumeration.BookType;
import com.example.demo.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookCreationRequest {
    @NotBlank(message="title cannot be blank")
    private String title;

    @NotBlank(message="bookNo cannot be blank")
    private String bookNo;

    @NotNull(message="Book Type cannot be blank")
    private BookType bookType;

    @Positive(message="positive numbers are expected")
    private Double securityAmount;

    @NotBlank(message="Author name cannot be blank")
    private String authorName;

    @NotBlank(message="Author name cannot be blank")
    private String authorEmail;

    public Book toBook(){
        return Book.builder().title(this.title).
                bookNo(this.bookNo).
                bookType(this.bookType).
                securityAmount(this.securityAmount).
                build();

    }

}
