package com.deathjack.DeathJack.cardTest;

import com.deathjack.DeathJack.domain.entity.Card;
import com.deathjack.DeathJack.domain.service.CardService;
import com.deathjack.DeathJack.domain.service.impl.CardServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardServiceTest {
    CardService cardService = new CardServiceImpl();

    @Test
    public void getAllCards() {
        List<Card> cardList = cardService.getAllCards();
        assertAll(
                () -> assertEquals("sA", cardList.get(0).getCard(), "La carta no es correcta"),
                () -> assertEquals(1, cardList.get(0).getId(), "El id no coincide"),
                () -> assertEquals("s2", cardList.get(1).getCard(), "La carta no es correcta"),
                () -> assertEquals(2, cardList.get(1).getId(), "El id no coincide")
        );
    }
}
