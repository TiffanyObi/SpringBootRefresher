package com.revature.SpringBootPrimer.repos;

import com.revature.SpringBootPrimer.models.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepo extends JpaRepository<Flashcard,Integer> {

    public Flashcard findByCategory(Flashcard.Category category);

}
