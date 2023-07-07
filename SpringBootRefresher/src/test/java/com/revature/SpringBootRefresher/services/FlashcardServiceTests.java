package com.revature.SpringBootRefresher.services;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardServiceTests {

    @Autowired
    FlashcardService fs;

    @MockBean
    FlashcardRepo fr;

//    @BeforeAll
//    public void setUpTestData(){
//        List<Flashcard> cards = new ArrayList<>();
//        Flashcard card = new Flashcard(0,"What is Spring MVC?", "Spring MVC is an integrated version" +
//                " of the Spring framework and Model View Controller", Flashcard.Category.SPRING);
//        card = fr.save(card);
//    }

    @Test
    public void createFlashcard(){
        Flashcard card = new Flashcard(0,"What is Spring Boot?", "An open-source micro-service based Java web"
                + " framework offered by Spring.", Flashcard.Category.SPRING);

        Mockito.when(fr.save(card)).thenReturn(new Flashcard(1,card.getQuestion(), card.getAnswer(), card.getCategory()));

        card = fs.createFlashcard(card);

        System.out.println(card);

        Assertions.assertNotEquals(0, card.getId());
        Assertions.assertEquals("What is Spring Boot?", card.getQuestion());
    }

    @Test
    public void viewAllFlashcard(){
        List<Flashcard> cards = new ArrayList<>();
//        Flashcard card = new Flashcard(0,"What is Spring MVC?", "Spring MVC is an integrated version" +
//                " of the Spring framework and Model View Controller", Flashcard.Category.SPRING);
//        Flashcard card2 = new Flashcard(0,"What is Spring Boot?", "An open-source micro-service based Java web"
//                + " framework offered by Spring.", Flashcard.Category.SPRING);
//        cards.add(card);
//        cards.add(card2);
//
//        Mockito.when(fr.findAll()).thenReturn(cards);

        cards = fs.findAllFlashcards();

        System.out.println(cards);
        Assertions.assertNotEquals(0, cards.size());
        Assertions.assertEquals(1,cards.get(0).getId());

    }


}
