package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@IdClass(AuthorCompositeKey.class)
public class Author extends TimeStamps{
    @Id
    private String id;

    @Id
    @Column(length=50)
    private String name;

    @Column(unique=true, nullable = false,length=50)
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;
}
