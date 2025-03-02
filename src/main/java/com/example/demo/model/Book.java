package com.example.demo.model;

import com.example.demo.enumeration.BookType;
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
public class Book extends TimeStamps {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(length=50)
    private String title;

    @Column(length=20, unique=true)
    private String bookNo;

    @Enumerated
    private BookType bookType;

    @Column(nullable = false)
    private Double securityAmount;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="author_id", referencedColumnName = "id"),
            @JoinColumn(name="author_name", referencedColumnName = "name")
    })
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Txn> txnList;

}
