package com.deathjack.DeathJack.inventoryTest;

import com.deathjack.DeathJack.domain.entity.Inventory;
import com.deathjack.DeathJack.domain.entity.Object;
import com.deathjack.DeathJack.domain.entity.Player;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTest {
    Player player = new Player(1, 1, "Beta", "Beta", true);
    List<Object> objectList = List.of(new Object(1, "Objeto1", "Primer objeto"), new Object(2, "Objeto2", "Segundo objeto"));

    Inventory inventory = new Inventory(1, player, objectList);

    @Test
    public void getObjectsAndPlayerNames() {
        assertAll(
                () -> assertEquals("Beta", inventory.getPlayer().getName(), "El nombre del jugador no es correcto"),
                () -> assertEquals("Objeto1", inventory.getObjects().get(0).getName(), "El nombre del objeto no es correcto"),
                () -> assertEquals("Objeto2", inventory.getObjects().get(1).getName(), "El nombre del objeto no es correcto")
        );
    }
}
