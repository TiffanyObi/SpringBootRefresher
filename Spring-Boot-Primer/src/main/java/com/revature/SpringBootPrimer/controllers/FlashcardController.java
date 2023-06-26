package com.revature.SpringBootPrimer.controllers;

import com.revature.SpringBootPrimer.models.Flashcard;
import com.revature.SpringBootPrimer.services.FlashcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller
@RestController
@RequestMapping("flashcards")
@RequiredArgsConstructor
public class FlashcardController {

    private final FlashcardService cardService;

    //here we want to set up our mappings for our app

    @GetMapping("/all")
    public List<Flashcard> findAllFlashcards(){
        return cardService.findAllFlashcards();
    }

    @PostMapping
    public Flashcard createFlashcard(@RequestBody Flashcard card){
        System.out.println("Requestbody: " + card);
        return cardService.createFlashcard(card);
    }

    @GetMapping("/{cardId}")
    public Flashcard findCardById(@PathVariable int cardId){
        System.out.println("Path Variable: " + cardId);
        return cardService.findCardById(cardId);
    }

    @GetMapping
    @ResponseBody
    public Flashcard findCardByCategory(@RequestParam Flashcard.Category category){
        System.out.println("Got Request Param: " + category);
        return cardService.findByCategory(category);
    }

}
