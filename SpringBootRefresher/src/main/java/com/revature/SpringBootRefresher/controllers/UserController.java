package com.revature.SpringBootRefresher.controllers;


import com.revature.SpringBootRefresher.models.User;
import com.revature.SpringBootRefresher.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    /*
    TODO: Set up controller to allow a user to register and login
     */

    private final UserService userService;


    @GetMapping("/users/all")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user){
        return userService.loginUser(user);
    }

    @PostMapping("/register")
    public User registerUser(User user){
        return userService.registerUser(user);
    }

    @GetMapping("/users")
    @ResponseBody
    public User findUserByUsername(@RequestParam String username){
        return userService.findUserByUsername(username);
    }
}
