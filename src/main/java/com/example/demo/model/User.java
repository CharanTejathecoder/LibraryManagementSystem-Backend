package com.example.demo.model;

import com.example.demo.enumeration.UserStatus;
import com.example.demo.enumeration.UserType;
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
@Table(name = "\"user\"")
public class User extends TimeStamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = true)
    private String name;

    @Column(nullable = false, length=15)
    private String phoneNo;

    @Column(unique = true, nullable = false, length=50)
    private String email;

    private String address;

    @Enumerated(value=EnumType.STRING)
    private UserStatus userStatus;

    @Enumerated(value=EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private List<Book> books;

    @OneToMany(mappedBy="user")
    private List<Txn> txnList;
}
