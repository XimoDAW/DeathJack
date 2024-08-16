package com.deathjack.DeathJack.playerTest;

import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.service.impl.PlayerServiceImpl;
import com.deathjack.DeathJack.persistance.repositoryImpl.PlayerRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerMockitoTest {
    @Mock
    private PlayerServiceImpl playerService;

    @InjectMocks
    private PlayerRepositoryImpl playerRepository;

    @Test
    void getPlayerById() {
        Player mockPlayer = new Player();
        mockPlayer.setId(1);
        mockPlayer.setId_score(1);
        mockPlayer.setPassword("password");
        mockPlayer.setBot(false);
        mockPlayer.setName("John Doe");

        when(playerService.getPlayerById(mockPlayer.getId())).thenReturn(Optional.of(mockPlayer));

        Optional <Player> player = playerService.getPlayerById(1);

        assertAll(
                () -> assertEquals(1, player.get().getId(), "El id no es el correcto"),
                () -> assertEquals("John Doe", player.get().getName(), "El nombre no es el correcto"),
                () -> assertEquals(1, player.get().getId_score(), "El id_score no es el correcto"),
                () -> assertEquals("password", player.get().getPassword(), "La contraseña no es correcta")
        );

        Mockito.verify(playerService, Mockito.times(1)).getPlayerById(1);
    }

    @Test
    public void getAllPlayers() {
        List<Player> mockPlayerList = new ArrayList<>();

        Player mockPlayer1 = new Player();
        mockPlayer1.setId(1);
        mockPlayer1.setId_score(1);
        mockPlayer1.setPassword("password");
        mockPlayer1.setBot(false);
        mockPlayer1.setName("John Doe");
        mockPlayerList.add(mockPlayer1);

        Player mockPlayer2 = new Player();
        mockPlayer2.setId(2);
        mockPlayer2.setId_score(2);
        mockPlayer2.setPassword("ximo");
        mockPlayer2.setBot(false);
        mockPlayer2.setName("Ximo");
        mockPlayerList.add(mockPlayer2);

        when(playerService.getAllPlayers()).thenReturn(mockPlayerList);

        List<Player> playerList = playerService.getAllPlayers();

        assertAll(
                () -> assertEquals(1, playerList.get(0).getId(), "El id no es el correcto"),
                () -> assertEquals("John Doe", playerList.get(0).getName(), "El nombre no es el correcto"),
                () -> assertEquals(1, playerList.get(0).getId_score(), "El id_score no es el correcto"),
                () -> assertEquals("password", playerList.get(0).getPassword(), "La contraseña no es correcta"),
                () -> assertEquals(2, playerList.get(1).getId(), "El id no es el correcto"),
                () -> assertEquals("Ximo", playerList.get(1).getName(), "El nombre no es el correcto"),
                () -> assertEquals(2, playerList.get(1).getId_score(), "El id_score no es el correcto"),
                () -> assertEquals("ximo", playerList.get(1).getPassword(), "La contraseña no es correcta")
        );
    }
}
