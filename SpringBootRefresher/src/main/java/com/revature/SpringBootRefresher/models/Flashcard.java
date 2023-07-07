package com.revature.SpringBootRefresher.models;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "flashcards")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
//@RequiredArgsConstructor
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotNull
    @Column(unique = true, nullable = false)
    private String question;

    @NotNull
    private String answer;

    @Enumerated
    private Category category;

    public enum Category {
        JAVA,SPRING,WEB,ANGULAR
    }

    /*
    TODO: Add an 'author' variable to the flashcard that is type user
     */



}
