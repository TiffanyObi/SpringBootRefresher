package com.revature.SpringBootRefresher.services;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
public class FlashcardService {

    private final FlashcardRepo cardRepo;

    public Flashcard createFlashcard(Flashcard flashcard){
        return cardRepo.save(flashcard);
    }

    public List<Flashcard> findAllFlashcards(){
        return cardRepo.findAll();
    }

    public Flashcard findById(int id){
        return cardRepo.findById(id).get();
    }

    public Flashcard findByCategory(Flashcard.Category category){
        return cardRepo.findByCategory(category);
    }

}
