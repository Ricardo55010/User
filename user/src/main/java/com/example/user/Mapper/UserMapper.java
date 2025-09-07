package com.example.user.Mapper;

import com.example.user.DTO.UserDTO;
import com.example.user.Models.User;

public class UserMapper {
    public static UserDTO mapUserToUserDTO(User user){
        return new UserDTO(user.getName(), user.getAge(), user.getWage());
    }

    public static User mapUserDTOToUser(UserDTO userDTO){
        return new User(userDTO.getName(), userDTO.getAge(), userDTO.getWage());
    }
}
