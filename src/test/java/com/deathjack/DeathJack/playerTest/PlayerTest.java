package com.deathjack.DeathJack.playerTest;

import com.deathjack.DeathJack.domain.entity.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    Player player = new Player(1, 1, "Beta", "Beta", true);

    @Test
    public void getNamePlayer () {
        assertEquals("Beta", player.getName(), "El nombre no coincide");
    }

}
