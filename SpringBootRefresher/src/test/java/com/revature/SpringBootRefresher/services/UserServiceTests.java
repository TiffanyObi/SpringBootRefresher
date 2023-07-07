package com.revature.SpringBootRefresher.services;

import com.revature.SpringBootRefresher.models.User;
import com.revature.SpringBootRefresher.repos.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserService us;

    @MockBean
    UserRepo ur;

    // Reminder: At this point I have my project connected to my localhost, so I don't have to create a setUp method
    // like I did in the FlashcardRepoTests
    @Test
    void loginUser(){
        User testUser = new User("newUser","pass123");

        Mockito.when(ur.findByUsername(testUser.getUsername())).thenReturn(new User(1,"newUser","pass123"));


        testUser = us.loginUser(testUser);

        Assertions.assertEquals(1,testUser.getId());
    }
}
