package com.deathjack.DeathJack.objectTest;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.persistance.dao.ObjectDAO;
import com.deathjack.DeathJack.persistance.entity.ObjectEntity;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectDAOTest {

    ObjectDAO objectDAO = new ObjectDAO();
    Connection connection = DBUtil.open(true);


    @Test
    public void getAllObjects() {
        List<ObjectEntity> objectEntityList = objectDAO.getAllObjects(connection);
        assertAll(
                () -> assertEquals("CHANGE!", objectEntityList.get(0).getName(), "El nombre no es el correcto"),
                () -> assertEquals(1, objectEntityList.get(0).getId(), "El id no coincide"),
                () -> assertEquals("Change your hand to the opponent", objectEntityList.get(0).getDescription(), "La descripcion no es la correcta"),
                () -> assertEquals("SHOTGUN", objectEntityList.get(1).getName(), "El nombre no es el correcto"),
                () -> assertEquals(2, objectEntityList.get(1).getId(), "El id no coincide"),
                () -> assertEquals("Shoot your opponent and he lost 1 hp", objectEntityList.get(1).getDescription(), "La descripcion no es la correcta")
        );
    }

    @Test
    public void getObjectById() {
        Optional<ObjectEntity> objectEntity = objectDAO.getObjectById(connection, 1);
        assertAll(
                () -> assertEquals("CHANGE!", objectEntity.get().getName(), "El nombre no es el correcto"),
                () -> assertEquals(1, objectEntity.get().getId(), "El id no coincide"),
                () -> assertEquals("Change your hand to the opponent", objectEntity.get().getDescription(), "La descripcion no es la correcta")
        );
    }
}
