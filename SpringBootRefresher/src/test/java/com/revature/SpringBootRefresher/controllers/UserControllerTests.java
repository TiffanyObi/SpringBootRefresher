package com.revature.SpringBootRefresher.controllers;

import com.revature.SpringBootRefresher.models.User;
import com.revature.SpringBootRefresher.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @MockBean
    UserService us;

   @Autowired
    MockMvc mvc;


    @Test
    void checkFindByUsernameQueryParam() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/users?username=newUser"));
        resultActions.andExpect(status().isOk());
    }

    @Test
    void checkValueFromUsernameQuery(){
        User actual = new User(1,"newUser","pass123");

        Mockito.when(us.findUserByUsername("newUser")).thenReturn(new User(1,"newUser","pass123"));

        User expected = us.findUserByUsername("newUser");

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getPassword(),actual.getPassword());

    }

}
