package com.example.user.Services;

import com.example.user.DTO.UserDTO;
import com.example.user.Mapper.UserMapper;
import com.example.user.Models.User;
import com.example.user.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final RabbitTemplate rabbitTemplate;
    private final UserRepository userRepository;
    public UserServiceImpl(RabbitTemplate rabbitTemplate,UserRepository userRepository){
        this.rabbitTemplate = rabbitTemplate;
        this.userRepository = userRepository;
    }
    public UserDTO getUser(long id){

        //UserDTO userDTO = UserMapper.mapUserToUserDTO(userRepository.findById(id).get());

        UserDTO userDTO = UserMapper.mapUserToUserDTO(userRepository.findById(id).get());
        System.out.println("sending:"+ userDTO.toString());

        return userDTO ;
    }
    public UserDTO createUser(String name){
        User user = new User(name,1,1200);
        userRepository.save(user);
        UserDTO userDTO = UserMapper.mapUserToUserDTO(user);
        //rabbitTemplate.convertAndSend("myExchange","my.routing.key", userDTO);
        return userDTO ;
    }

    public UserDTO updateUser(UserDTO userDTO){
        System.out.println(userDTO.getName());
        User user = userRepository.findById(userDTO.getId()).get();
        user.setName(user.getName());
        userRepository.save(user);
        return UserMapper.mapUserToUserDTO(user);
    }

    public UserDTO deleteUser(long id){
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        UserDTO userDTO = UserMapper.mapUserToUserDTO(user);
        return userDTO;
    }



}