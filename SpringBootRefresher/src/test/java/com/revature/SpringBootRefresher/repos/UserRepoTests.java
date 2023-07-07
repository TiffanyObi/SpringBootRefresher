package com.revature.SpringBootRefresher.repos;

import com.revature.SpringBootRefresher.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepoTests {

    @Autowired
    public UserRepo ur;


    @Test
    void registerUser(){
        User newUser = new User(0,"newUser","pass123");

        newUser = ur.save(newUser);

        Assertions.assertEquals(1,newUser.getId());
    }



}
