package com.example.user;

import com.example.user.Models.User;
import com.example.user.Services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.TestPropertySource;

import static org.mockito.Mockito.when;


@SpringBootTest(classes = UserApplication.class) //point where the main class is to find beans tbat can be injected during the test
//checar para que es randomport en springbootest environment
@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureGraphQlTester //THIS ONLY COMES WITH @GRAPHQL ANNOTATION, WHEN SPRINGBOOTTEST IS USED ITS GOT TO BE MANUALLY ADDED
public class UserControllerIntegrationTest {

    @Autowired
    private GraphQlTester graphQlTester;
    @Mock
    private UserService userService; //mocking although it coulbe @ autowired to
    @Test
    void testGetUsers(){

        User user = new User("si",22,2);
        when(userService.getUser(1)).thenReturn(null);

        graphQlTester.documentName("User")
                .execute().path("getUser").entityList(
                        User.class
                ).hasSizeGreaterThan(0);
    }
}
