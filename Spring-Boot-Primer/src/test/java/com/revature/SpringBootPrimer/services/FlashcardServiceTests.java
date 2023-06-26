package com.revature.SpringBootPrimer.services;

import com.revature.SpringBootPrimer.models.Flashcard;
import com.revature.SpringBootPrimer.repos.FlashcardRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

/*
Notes:

 @Mock annotation - Used to make Mockito create a mock object.

 @MockBean annotation - Can be used to add mock objects to the Spring application context.
 The mock will replace any existing bean of the same type in the application context.
 If no bean of the same type is defined, a new one will be added. Often used together with @SpringBootTest

 @InjectMock annotation - When you want Mockito to create an instance of an object
  and use the mocks annotated with @Mock as its dependencies.

 & @Autowired annotation - Used when you want to autowire a bean from the spring context:
  Works exactly the same as in normal code but can only be used in tests that actually create an application context,
  such as tests annotated with @WebMvcTest or @SpringBootTest.

So normally you either:

Use @Mock and @InjectMocks for running tests without a Spring context;

or

Use @SpringBootTest or @SpringMvcTest to start a spring context together with @MockBean to create mock objects
 and @Autowired to get an instance of class you want to test, the mockbeans will be used for its autowired dependencies.
 You use this when writing integration tests for code that interact with a database or want to test your REST API controllers.

aka what we are doing now

 */

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardServiceTests {

    @Autowired
    FlashcardService fs;

    @MockBean
    FlashcardRepo fr;

//    @BeforeAll
//    public void setUpData(){
//        Flashcard card = new Flashcard(0,"What is Spring MVC?","Spring MVC is an integrated version of " +
//                "the Spring framework and Model View Controller", Flashcard.Category.SPRING);
//        card = fr.save(card);
//
//    }

    @Test
    public void createFlashcard(){
        Flashcard card = new Flashcard(0,"What is Spring Boot?","Spring Boot is an open-source, " +
                "microservice-based Java web framework offered by Spring", Flashcard.Category.SPRING);

        Mockito.when(fr.save(card)).thenReturn(new Flashcard(1, card.getQuestion(), card.getAnswer(), card.getCategory()));

        card = fs.createFlashcard(card);

        Assertions.assertNotEquals(0, card.getId());
        Assertions.assertEquals("What is Spring Boot?",card.getQuestion());
        Assertions.assertEquals(Flashcard.Category.SPRING, card.getCategory());

    }

    @Test
    public void viewAllFlashcards(){

        List<Flashcard> cards = new ArrayList<>();
        Flashcard card = new Flashcard(1,"What is Spring MVC?","Spring MVC is an integrated version of " +
                "the Spring framework and Model View Controller", Flashcard.Category.SPRING);
        cards.add(card);


        Mockito.when(fr.findAll()).thenReturn(cards);
        cards = fs.findAllFlashcards();

        System.out.println(cards);
        Assertions.assertNotEquals(0,cards.size());
        Assertions.assertEquals(1,cards.get(0).getId());
    }

}
