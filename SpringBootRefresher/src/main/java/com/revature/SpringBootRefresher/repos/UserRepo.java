package com.revature.SpringBootRefresher.repos;

import com.revature.SpringBootRefresher.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    /*
    TODO: Set up the repo for our User object
    Add any unique methods an necessary
     */

    public User findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);
}
