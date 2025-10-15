package com.example.user.UnitTest;

import com.example.user.Controller.UserController;
import com.example.user.DTO.UserDTO;
import com.example.user.Models.User;
import com.example.user.Services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@GraphQlTest(UserController.class)
//@ExtendWith(MockitoExtension.class) not recommended when using both spring and mockito together
@Import(UserTestConfig.class) //alternative to @mockbean since it's been deprecated
public class UserControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;
    @Autowired
    private UserService userService;
    @Test
    void testGetUsers(){

        UserDTO user = new UserDTO("Richard",22,2);
        when(userService.getUser(1)).thenReturn(user);

        graphQlTester.document("{ getUser(id: 1) { name } }")
                .execute().path("getUser.name").entity(
                        String.class
                ).isEqualTo("Richard");
    }

    @Test
    void testCreateUser(){

        UserDTO user = new UserDTO("Richard",22,2);
        when(userService.createUser(user)).thenReturn(user);

        graphQlTester.document("mutation { createUser(name: \"Richard\") {  name } }")
                .execute()
                .path("createUser.name").entity(String.class).isEqualTo("Richard");

    }

    @Test
    void testUpdateUser(){

        UserDTO user = new UserDTO("Richard",22,2);
        when(userService.updateUser(any(UserDTO.class))).thenReturn(user); //for any instance of UserDto sent

        graphQlTester.document("mutation { updateUser(user: { id: 22, name : \"Richard\" }) {  name } }")
                .execute()
                .path("updateUser.name").entity(String.class).isEqualTo("Richard");

    }

    @Test
    void testDeleteUser(){

        UserDTO user = new UserDTO("Richard",22,2);
        when(userService.deleteUser(any(long.class))).thenReturn(user); //for any instance of long sent

        graphQlTester.document("mutation { deleteUser(id: 22 ) {  name } }")
                .execute()
                .path("deleteUser.name").entity(String.class).isEqualTo("Richard");

    }
}

//This generates a mock of UserService in the context of spring
@TestConfiguration
class UserTestConfig {
    @Bean
    @Primary
    UserService userService() {
        return Mockito.mock(UserService.class);
    }
}