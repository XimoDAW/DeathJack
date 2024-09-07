package com.deathjack.DeathJack.cardTest;

import com.deathjack.DeathJack.domain.entity.Card;
import com.deathjack.DeathJack.domain.service.impl.CardServiceImpl;
import com.deathjack.DeathJack.persistance.repositoryImpl.CardRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardMockitoTest {
    @Mock
    CardServiceImpl cardService;
    @InjectMocks
    CardRepositoryImpl cardRepository;

    @Test
    public void getAllCards() {
        List<Card> mockCardList = new ArrayList<>();
        Card mockCard = new Card();
        mockCard.setId(1);
        mockCard.setCard("Prueba");
        mockCardList.add(mockCard);

        Card mockCard2 = new Card();
        mockCard2.setId(2);
        mockCard2.setCard("Colores");
        mockCardList.add(mockCard2);

        when(cardService.getAllCards()).thenReturn(mockCardList);

        List<Card> cardList = cardService.getAllCards();

        assertAll(
                () -> assertEquals(1, cardList.get(0).getId(), "El id no es el correcto"),
                () -> assertEquals("Prueba", cardList.get(0).getCard(), "La carta no es correcta"),
                () -> assertEquals(2, cardList.get(1).getId(), "El id no es el correcto"),
                () -> assertEquals("Colores", cardList.get(1).getCard(), "La carta no es correcta")
        );

    }
}
