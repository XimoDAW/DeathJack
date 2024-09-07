package com.deathjack.DeathJack.controller;

import com.deathjack.DeathJack.controller.entity.CardListWeb;
import com.deathjack.DeathJack.domain.entity.Card;
import com.deathjack.DeathJack.domain.service.CardService;
import com.deathjack.DeathJack.domain.service.impl.CardServiceImpl;
import com.deathjack.DeathJack.http_response.Response;
import com.deathjack.DeathJack.mapper.CardMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CardController {
    CardService cardService = new CardServiceImpl();

    @GetMapping("/deathjack/cards")
    public Response getAllCards () {
        List<Card> cardList = cardService.getAllCards();
        List<CardListWeb> cardListWebList = new ArrayList<>();

        cardList.stream().map(card -> {
            return cardListWebList.add(CardMapper.toCardListWeb(card));
        }).toList();
        return new Response(cardListWebList);
    }
}
