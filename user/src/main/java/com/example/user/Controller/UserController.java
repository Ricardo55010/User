package com.example.user.Controller;

import com.example.user.Models.User;
import com.example.user.Services.UserServiceImpl;
import com.example.user.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @QueryMapping
    public ResponseEntity<User> getUser(){
        return ResponseEntity.ok(new User("Ricardo",10,1500));
    }
}