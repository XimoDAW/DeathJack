package com.deathjack.DeathJack;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.repository.PlayerRepository;
import com.deathjack.DeathJack.persistance.repositoryImpl.PlayerRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerRepositoryTest {
    PlayerRepository playerRepository = new PlayerRepositoryImpl();
    Connection connection = DBUtil.open(true);

    @Test
    public void getPlayerById() {
        Player player = playerRepository.getPlayerById(1).get();

        assertAll(
                () -> assertEquals(1, player.getId(), "El id no coincide"),
                () -> assertEquals("CROUPIER", player.getName(), "El nombre es incorrecto"),
                () -> assertEquals(0, player.getId_score(), "El id_score no coincide"),
                () -> assertEquals( null, player.getPassword(), "La contraseña no es correcta"),
                () -> assertEquals(true, player.isBot(), "El jugador no es bot")
        );
    }
}
