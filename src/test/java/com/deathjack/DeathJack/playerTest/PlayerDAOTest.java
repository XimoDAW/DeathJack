package com.deathjack.DeathJack.playerTest;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.persistance.dao.PlayerDAO;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlayerDAOTest {
    PlayerDAO playerDAO = new PlayerDAO();
    Connection connection = DBUtil.open(true);

    @Test
    public void getPlayerEntityById() {
        Optional<PlayerEntity> playerEntity = playerDAO.getPlayerById(connection, 1);

        assertAll(
                () -> assertEquals(1, playerEntity.get().getId(), "El id no coincide"),
                () -> assertEquals("CROUPIER", playerEntity.get().getName(), "El nombre es incorrecto"),
                () -> assertEquals(0, playerEntity.get().getId_score(), "El id_score no coincide"),
                () -> assertEquals( null, playerEntity.get().getPassword(), "La contraseña no es correcta"),
                () -> assertEquals(true, playerEntity.get().isBot(), "El jugador no es bot")
        );
    }

    @Test
    public void getAllPlayers() {
        List<PlayerEntity> playerEntityList = playerDAO.getAllPlayers(connection);
        assertAll(
                () -> assertEquals(1, playerEntityList.get(0).getId(), "El id no coincide"),
                () -> assertEquals("CROUPIER", playerEntityList.get(0).getName(), "El nombre es incorrecto"),
                () -> assertEquals(0, playerEntityList.get(0).getId_score(), "El id_score no coincide"),
                () -> assertEquals( null, playerEntityList.get(0).getPassword(), "La contraseña no es correcta"),
                () -> assertEquals(true, playerEntityList.get(0).isBot(), "El jugador no es bot")
        );
    }
}