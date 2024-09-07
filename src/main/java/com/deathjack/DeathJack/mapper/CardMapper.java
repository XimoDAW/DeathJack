package com.deathjack.DeathJack.mapper;

import com.deathjack.DeathJack.controller.entity.CardListWeb;
import com.deathjack.DeathJack.domain.entity.Card;
import com.deathjack.DeathJack.persistance.entity.CardEntity;

import java.sql.ResultSet;

public class CardMapper {

    public static CardEntity toCardEntity(ResultSet resultSet) {
        try {
            CardEntity cardEntity = new CardEntity();
            cardEntity.setId(resultSet.getInt("id"));
            cardEntity.setCard(resultSet.getString("card"));
            return cardEntity;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public static Card toCard(CardEntity cardEntity) {
        try {
            Card card = new Card();
            card.setId(cardEntity.getId());
            card.setCard(cardEntity.getCard());
            return card;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public static CardListWeb toCardListWeb (Card card) {
        try {
            CardListWeb cardListWeb = new CardListWeb();
            cardListWeb.setId(card.getId());
            cardListWeb.setCard(card.getCard());
            return cardListWeb;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
