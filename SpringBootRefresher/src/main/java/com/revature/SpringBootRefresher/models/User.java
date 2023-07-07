package com.revature.SpringBootRefresher.models;

import lombok.*;

import javax.persistence.*;

/*
@Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor
annotations on the class (except that no constructor will be generated if any explicitly written constructors already exist).
 */
@Entity(name = "users")
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    // note I'll change @Data to the individual annotations becuase i need a custom constructor
    //when a user is login in i should be anle to just oass over a username a password in my user object without the id


    /*
    TODO: Create a User Object
    -id primary key
    -username  unique , not null
    -password not null

    Note: we can user lombok for all of our "Data" methods
     */

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
}
