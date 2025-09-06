package com.example.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final RabbitTemplate rabbitTemplate;
    public UserService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }
    public void getUser(){
        rabbitTemplate.convertAndSend("myExchange","my.routing.key", new String("Starting communication with another microservice"));
    }
}
