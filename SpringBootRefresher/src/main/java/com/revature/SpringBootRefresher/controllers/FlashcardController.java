package com.revature.SpringBootRefresher.controllers;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import com.revature.SpringBootRefresher.services.FlashcardService;
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

    @GetMapping("/all")
    public List<Flashcard> findAllFlashcards(){
        return cardService.findAllFlashcards();
    }


    @PostMapping
    public Flashcard createFlashcard(@RequestBody Flashcard card){
        return cardService.createFlashcard(card);
    }


    @GetMapping("/{cardId}")
    public Flashcard findCardById(@PathVariable int cardId){
        return cardService.findById(cardId);
    }

    @GetMapping
    @ResponseBody
    public Flashcard findByCategory(@RequestParam Flashcard.Category category){
        return cardService.findByCategory(category);
    }


    //if I didn't want to create so many getMappings (with different  added uri (/"someEndpoint")
    // I could create a helper method that would use the uri to execute the proper method .
    // example to come!!!

}
