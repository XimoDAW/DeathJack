package com.deathjack.DeathJack.objectTest;

import com.deathjack.DeathJack.domain.entity.Object;
import com.deathjack.DeathJack.domain.repository.ObjectRepository;
import com.deathjack.DeathJack.persistance.repositoryImpl.ObjectRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectRepositoryTest {
    ObjectRepository objectRepository = new ObjectRepositoryImpl();

    @Test
    public void getAllObjects() {
        List<Object> objectList = objectRepository.getAllObjects();
        assertAll(
                () -> assertEquals("CHANGE!", objectList.get(0).getName(), "El nombre no es el correcto"),
                () -> assertEquals(1, objectList.get(0).getId(), "El id no coincide"),
                () -> assertEquals("Change your hand to the opponent", objectList.get(0).getDescription(), "La descripcion no es la correcta"),
                () -> assertEquals("SHOTGUN", objectList.get(1).getName(), "El nombre no es el correcto"),
                () -> assertEquals(2, objectList.get(1).getId(), "El id no coincide"),
                () -> assertEquals("Shoot your opponent and he lost 1 hp", objectList.get(1).getDescription(), "La descripcion no es la correcta")
        );
    }
}
