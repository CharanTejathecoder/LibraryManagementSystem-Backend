package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserFilterResponse {
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userPhoneNo;
}
