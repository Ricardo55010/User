package com.example.user.Services;

import com.example.user.DTO.UserDTO;

public interface UserService {
    public UserDTO getUser(long id);
    public UserDTO createUser(String name);
}
