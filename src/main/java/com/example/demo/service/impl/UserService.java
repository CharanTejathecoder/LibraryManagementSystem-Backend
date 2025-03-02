package com.example.demo.service.impl;

import com.example.demo.dto.UserCreationRequest;
import com.example.demo.dto.UserCreationResponse;
import com.example.demo.dto.UserFilterResponse;
import com.example.demo.enumeration.Operator;
import com.example.demo.enumeration.UserFilter;
import com.example.demo.enumeration.UserType;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserFilterResponse> filter(UserFilter filterBy, Operator operator, String value) {

        List<User> filteredUserList = new ArrayList<User>() ;
        List<UserFilterResponse> filteredUserResponseList = new ArrayList<UserFilterResponse>();
        switch (filterBy){
            case UserFilter.NAME :
                switch (operator)
                {
                    case Operator.EQUAL:
                        filteredUserList = userRepository.findByName(value);
                        break;
                    case Operator.LIKE:
                        filteredUserList = userRepository.findByNameContains(value);
                        break;
                }
                break;

            case UserFilter.EMAIL:
                switch (operator)
                {
                    case Operator.EQUAL:
                        filteredUserList = userRepository.findByEmail(value);
                        break;
                    case Operator.LIKE:
                        filteredUserList = userRepository.findByEmailContains(value);
                        break;
                }
                break;

            case UserFilter.PHONE_NO:
                switch (operator)
                {
                    case Operator.EQUAL:
                        filteredUserList = userRepository.findByPhoneNo(value);
                        break;
                    case Operator.LIKE:
                        filteredUserList = userRepository.findByPhoneNoContains(value);
                        break;
                }
                break;
        }
    filteredUserList.forEach(user -> filteredUserResponseList.addLast(UserFilterResponse.builder().
            userAddress(user.getAddress()).
            userPhoneNo(user.getPhoneNo()).
            userName(user.getName()).
            userEmail(user.getEmail()).
            build()));
    return filteredUserResponseList;
    }

    public UserCreationResponse addStudent(UserCreationRequest request) {
        User user= request.toUser();
        user.setUserType(UserType.STUDENT);
        User userFromDb= userRepository.save(user);
        return UserCreationResponse.builder().
                userAddress(userFromDb.getAddress()).
                userEmail(userFromDb.getEmail()).
                userName(userFromDb.getName()).
                userPhoneNo(userFromDb.getPhoneNo()).
                build();
    }
}
