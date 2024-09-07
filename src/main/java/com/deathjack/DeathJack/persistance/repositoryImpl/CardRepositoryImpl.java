package com.deathjack.DeathJack.persistance.repositoryImpl;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.domain.entity.Card;
import com.deathjack.DeathJack.domain.repository.CardRepository;
import com.deathjack.DeathJack.mapper.CardMapper;
import com.deathjack.DeathJack.persistance.dao.CardDAO;
import com.deathjack.DeathJack.persistance.entity.CardEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {
    @Override
    public List<Card> getAllCards() {
        CardDAO cardDAO = new CardDAO();
        try (Connection connection = DBUtil.open(true)){
            List<CardEntity> cardEntityList = cardDAO.getAllCards(connection);
            List<Card> cardList = new ArrayList<>();

            cardEntityList.stream().map(
                    cardEntity -> {
                        return cardList.add(CardMapper.toCard(cardEntity));
                    }
            ).toList();

            return cardList;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
