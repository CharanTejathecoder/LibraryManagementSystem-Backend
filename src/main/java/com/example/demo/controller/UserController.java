package com.example.demo.controller;

import com.example.demo.dto.UserCreationRequest;
import com.example.demo.dto.UserCreationResponse;
import com.example.demo.dto.UserFilterResponse;
import com.example.demo.enumeration.Operator;
import com.example.demo.enumeration.UserFilter;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addStudent")
    public UserCreationResponse addStudent(@RequestBody @Validated UserCreationRequest request){
        return userService.addStudent(request);
    }

    @GetMapping("/filter")
    public List<UserFilterResponse> filtered(@RequestParam("filterBy") UserFilter filterBy,
                                                    @RequestParam("operator") Operator operator,
                                                    @RequestParam("value") String value){
        return userService.filter(filterBy,operator,value);
    }
}
