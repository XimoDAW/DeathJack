package com.deathjack.DeathJack.playerTest;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.repository.PlayerRepository;
import com.deathjack.DeathJack.persistance.repositoryImpl.PlayerRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

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

    @Test
    public void getAllPlayers() {
        List<Player> playerList = playerRepository.getAllPlayers();

        assertAll(
                () -> assertEquals(1, playerList.get(0).getId(), "El id no coincide"),
                () -> assertEquals("CROUPIER", playerList.get(0).getName(), "El nombre es incorrecto"),
                () -> assertEquals(0, playerList.get(0).getId_score(), "El id_score no coincide"),
                () -> assertEquals( null, playerList.get(0).getPassword(), "La contraseña no es correcta"),
                () -> assertEquals(true, playerList.get(0).isBot(), "El jugador no es bot")
        );
    }
}
