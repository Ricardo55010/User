package com.example.user.Services;

import com.example.user.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final RabbitTemplate rabbitTemplate;

    public UserServiceImpl(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }
    public User getUser(){
        rabbitTemplate.convertAndSend("myExchange","my.routing.key", new String("Starting communication with another microservice"));
        return new User("Marisol",1,1000);
    }
    public User createUser(){

        return new User("Marisol",1,1000);
    }

}