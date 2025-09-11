package com.example.user;

import com.example.user.Models.User;
import com.example.user.Services.UserService;
import com.example.user.Services.UserServiceImpl;
import org.glassfish.jaxb.runtime.v2.runtime.reflect.opt.Const;
import org.hibernate.graph.Graph;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.engine.Constants;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@GraphQlTest(UserControllerTest.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;
    @Mock
    private UserService userService;
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
