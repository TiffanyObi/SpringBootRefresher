package com.revature.SpringBootRefresher.repos;

import com.revature.SpringBootRefresher.models.Flashcard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardRepoTests {

    @Autowired
    public FlashcardRepo fr;


    @BeforeAll
    void setUpTestData(){
        Flashcard card = new Flashcard(0,"What is Spring MVC?", "Spring MVC is an integrated version" +
                " of the Spring framework and Model View Controller", Flashcard.Category.SPRING);
        card = fr.save(card);

    }


    @Test
    void createFlashcard(){
        Flashcard card = new Flashcard(0,"What is Spring Boot?", "An open-source micro-service based Java web"
        + " framework offered by Spring.", Flashcard.Category.SPRING);
        card = fr.save(card);

        System.out.println(card.getId());

        Assertions.assertNotEquals(0,card.getId());
    }

    @Test
    void viewAllFlashcards(){
        List<Flashcard> cards = fr.findAll();
        System.out.println(cards);
        Assertions.assertFalse(cards.isEmpty());
    }
}
