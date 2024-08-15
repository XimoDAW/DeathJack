package com.deathjack.DeathJack;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.persistance.dao.PlayerDAO;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlayerDAOTest {
    PlayerDAO playerDAO = new PlayerDAO();
    Connection connection = DBUtil.open(true);

    @Test
    public void getPlayerEntityById() {
        Optional<PlayerEntity> playerEntity = playerDAO.getById(connection, 1);

        assertAll(
                () -> assertEquals(1, playerEntity.get().getId(), "El id no coincide"),
                () -> assertEquals("CROUPIER", playerEntity.get().getName(), "El nombre es incorrecto"),
                () -> assertEquals(0, playerEntity.get().getId_score(), "El id_score no coincide"),
                () -> assertEquals( null, playerEntity.get().getPassword(), "La contraseña no es correcta"),
                () -> assertEquals(true, playerEntity.get().isBot(), "El jugador no es bot")
        );


    }
}