package com.revature.SpringBootPrimer.controllers;

import com.revature.SpringBootPrimer.models.Flashcard;
import com.revature.SpringBootPrimer.services.FlashcardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.lang.management.MonitorInfo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardControllerTests {

    @MockBean
    FlashcardService fs;

    @Autowired
    MockMvc mvc;

//    @BeforeAll
//    void setUpTestData(){
//        Flashcard card = new Flashcard(0,"What is Spring Boot?","Spring Boot is an open-source, " +
//                "microservice-based Java web framework offered by Spring", Flashcard.Category.SPRING);
//        card = fs.createFlashcard(card);
//    }


    @Test
    public void getCardById() throws Exception{

//        Mockito.when(fs.findCardById(1)).thenReturn(new Flashcard(1,"What is Spring Boot?","Spring Boot is an open-source, " +
//                "microservice-based Java web framework offered by Spring", Flashcard.Category.SPRING));

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/flashcards/1"));
            resultActions.andExpect(status().isOk());
    }

    @Test
    public void checkValueFromGetByIdRequest(){
        Flashcard actual = new Flashcard(7,"What is Spring Boot?","Spring Boot is an open-source, " +
                "microservice-based Java web framework offered by Spring", Flashcard.Category.SPRING);

       Mockito.when(fs.findCardById(1)).thenReturn(new Flashcard(1,"What is Spring Boot?","Spring Boot is an open-source, " +
               "microservice-based Java web framework offered by Spring", Flashcard.Category.SPRING));

        Assertions.assertNotEquals(fs.findCardById(1).getId(),actual.getId());

    }
}
