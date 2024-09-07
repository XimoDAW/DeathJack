package com.deathjack.DeathJack.domain.repository;

import com.deathjack.DeathJack.domain.entity.Card;
import com.deathjack.DeathJack.domain.entity.Object;

import java.util.List;

public interface CardRepository {
    public List<Card> getAllCards ();
}
