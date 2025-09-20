package com.example.user.Services;

import com.example.user.DTO.UserDTO;
import com.example.user.Models.User;

public interface UserService {
    public UserDTO getUser(long id);
    public UserDTO createUser(String name);
    public UserDTO updateUser(String name, Long id);
    public UserDTO deleteUser(long id);
}
