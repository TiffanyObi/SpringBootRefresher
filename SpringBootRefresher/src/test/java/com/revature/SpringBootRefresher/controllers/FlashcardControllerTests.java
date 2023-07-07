package com.revature.SpringBootRefresher.controllers;


import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.services.FlashcardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FlashcardControllerTests {

    @MockBean
    FlashcardService fs;

    @Autowired
    MockMvc mvc;



    @Test
    public void getCardById() throws Exception{
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/flashcards/1"));
        resultActions.andExpect(status().isOk());
    }


    @Test
    public void checkValueFromBetByIdRequest(){
        Flashcard actual = new Flashcard(0,"What is Spring MVC?", "Spring MVC is an integrated version" +
                " of the Spring framework and Model View Controller", Flashcard.Category.SPRING);

        Mockito.when(fs.findById(1)).thenReturn(new Flashcard(1,"What is Spring MVC?","Spring MVC is an integrated version" +
                " of the Spring framework and Model View Controller", Flashcard.Category.SPRING));

        Assertions.assertNotEquals(fs.findById(1).getId(), actual.getId());
    }



}
