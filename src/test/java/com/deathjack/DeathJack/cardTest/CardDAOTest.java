package com.deathjack.DeathJack.cardTest;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.persistance.dao.CardDAO;
import com.deathjack.DeathJack.persistance.entity.CardEntity;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardDAOTest {

    CardDAO cardDAO = new CardDAO();
    Connection connection = DBUtil.open(true);


    @Test
    public void getAllCards() {
        List<CardEntity> cardEntityList = cardDAO.getAllCards(connection);
        assertAll(
                () -> assertEquals("sA", cardEntityList.get(0).getCard(), "La carta no es correcta"),
                () -> assertEquals(1, cardEntityList.get(0).getId(), "El id no coincide"),
                () -> assertEquals("s2", cardEntityList.get(1).getCard(), "La carta no es correcta"),
                () -> assertEquals(2, cardEntityList.get(1).getId(), "El id no coincide")
        );
    }
}
