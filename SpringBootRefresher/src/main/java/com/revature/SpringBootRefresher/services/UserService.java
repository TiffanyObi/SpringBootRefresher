package com.revature.SpringBootRefresher.services;

import com.revature.SpringBootRefresher.models.User;
import com.revature.SpringBootRefresher.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    /*
    TODO: Set up the service for the user objects
    -register (create new user)
    -login (authenticate user)

    Bonus:
    -findAllUsers
    -find user by Username

     */
    private final UserRepo userRepo;

    public User registerUser(User user){
        return userRepo.save(user);
    }


    public User loginUser(User user){
        User userByUsername = userRepo.findByUsername(user.getUsername());
        return (userByUsername.getPassword().equals(user.getPassword()) ? userByUsername : null);
    }

    //curious to see what the SQL query would look like
    // as well as the result
    public User loginUsingUsernameAndPassword(User user){
        User userFromdb = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        return (!userFromdb.equals(null) ? userFromdb : null);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User findUserByUsername(String username){
        return userRepo.findByUsername(username);
    }

}
