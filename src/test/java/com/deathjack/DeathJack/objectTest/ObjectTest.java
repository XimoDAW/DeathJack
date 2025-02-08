package com.deathjack.DeathJack.objectTest;

import com.deathjack.DeathJack.domain.entity.Object;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectTest {
    Object object = new Object(1, "Objeto", "Objeto de prueba");

    @Test
    public void getObjectName() {
        assertEquals("Objeto", object.getName(), "El nombre no coincide");
    }
}
