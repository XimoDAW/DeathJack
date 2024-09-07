package com.deathjack.DeathJack.cardTest;

import com.deathjack.DeathJack.domain.entity.Card;
import com.deathjack.DeathJack.domain.repository.CardRepository;
import com.deathjack.DeathJack.persistance.repositoryImpl.CardRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardRepositoryTest {
    CardRepository cardRepository = new CardRepositoryImpl();

    @Test
    public void getAllCards() {
        List<Card> cardList = cardRepository.getAllCards();
        assertAll(
                () -> assertEquals("sA", cardList.get(0).getCard(), "La carta no es correcta"),
                () -> assertEquals(1, cardList.get(0).getId(), "El id no coincide"),
                () -> assertEquals("s2", cardList.get(1).getCard(), "La carta no es correcta"),
                () -> assertEquals(2, cardList.get(1).getId(), "El id no coincide")
        );
    }
}
