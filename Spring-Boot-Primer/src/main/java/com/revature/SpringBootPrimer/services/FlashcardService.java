package com.revature.SpringBootPrimer.services;

import com.revature.SpringBootPrimer.models.Flashcard;
import com.revature.SpringBootPrimer.repos.FlashcardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlashcardService {

    private final FlashcardRepo cardRepo;

    public Flashcard createFlashcard(Flashcard flashcard){
        return cardRepo.save(flashcard);
    }

    public List<Flashcard> findAllFlashcards() {
        return cardRepo.findAll();
    }

    public Flashcard findCardById(int id){

        return cardRepo.findById(id).get();
    }

    public  Flashcard findByCategory(Flashcard.Category category){
        return cardRepo.findByCategory(category);
    }



}
