package com.deathjack.DeathJack.cardTest;

import com.deathjack.DeathJack.domain.entity.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    Card card = new Card(1, "Joker");
    @Test
    public void getCardName() {
        assertEquals("Joker", card.getCard(), "El nombre no es correcto");
    }
}
