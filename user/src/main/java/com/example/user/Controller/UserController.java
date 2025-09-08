package com.example.user.Controller;

import com.example.user.DTO.UserDTO;
import com.example.user.Services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;

@Controller
public class UserController {
    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @QueryMapping
    public UserDTO getUser(@Argument long id){
        UserDTO userDTO = userService.getUser(id);
        return userDTO;
    }

    @MutationMapping
    public UserDTO createUser(@Argument String name){
        UserDTO userDTO = userService.createUser(name);
        return userDTO;
    }
}