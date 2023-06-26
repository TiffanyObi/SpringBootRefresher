package com.revature.SpringBootPrimer.models;

import com.sun.xml.bind.v2.TODO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "flashcards")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String question;

    @NotNull
    private String answer;

    @Enumerated
    private Category category;
    public enum Category {
        JAVA, WEB, SPRING, ANGULAR
    }

    /*
    TODO: Add an 'author' variable to the flashcard that is of type User.
     */
}
