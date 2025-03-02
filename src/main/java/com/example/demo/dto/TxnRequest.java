package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TxnRequest {
    @NotBlank(message = "user email cannot be blank")
    private String userEmail;
    @NotBlank(message = "user email cannot be blank")
    private String bookNo;

}
