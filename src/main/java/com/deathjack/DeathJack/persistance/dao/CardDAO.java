package com.deathjack.DeathJack.persistance.dao;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.mapper.CardMapper;
import com.deathjack.DeathJack.persistance.entity.CardEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CardDAO {

    public List<CardEntity> getAllCards(Connection connection) {
        try {
            String sql = "SELECT * FROM cards";
            ResultSet resultSet = DBUtil.select(connection, sql, null);
            List<CardEntity> cardEntityList = new ArrayList<>();

            while (resultSet.next()) {
                CardEntity cardEntity = CardMapper.toCardEntity(resultSet);
                cardEntityList.add(cardEntity);
            }

            return cardEntityList;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
