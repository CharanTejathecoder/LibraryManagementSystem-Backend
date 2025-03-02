package com.example.demo.dto;

import com.example.demo.enumeration.UserStatus;
import com.example.demo.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserCreationRequest {

    private String userName;

    @NotBlank(message = "Email cannot be blank")
    private String userEmail;

    private String  userAddress;

    private String userPhoneNo;

    public User toUser() {
        return User.builder().
                name(this.userName).
                email(this.userEmail).
                phoneNo(this.userPhoneNo).
                address(this.userAddress).
                userStatus(UserStatus.ACTIVE).

                build();
    }
}

