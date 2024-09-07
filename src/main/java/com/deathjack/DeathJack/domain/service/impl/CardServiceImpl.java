package com.deathjack.DeathJack.domain.service.impl;

import com.deathjack.DeathJack.domain.entity.Card;
import com.deathjack.DeathJack.domain.repository.CardRepository;
import com.deathjack.DeathJack.domain.service.CardService;
import com.deathjack.DeathJack.persistance.repositoryImpl.CardRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    CardRepository cardRepository = new CardRepositoryImpl();
    @Override
    public List<Card> getAllCards() {
        return cardRepository.getAllCards();
    }
}
