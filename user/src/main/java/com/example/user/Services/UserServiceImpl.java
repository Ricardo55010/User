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
        rabbitTemplate.convertAndSend("myExchange","my.routing.key", new String("Starting communication with another microservice"));
        UserDTO userDTO = UserMapper.mapUserToUserDTO(userRepository.findById(id).get());
        return userDTO ;
    }
    public UserDTO createUser(String name){
        User user = new User(name,1,1200);
        return UserMapper.mapUserToUserDTO(user);
    }

}