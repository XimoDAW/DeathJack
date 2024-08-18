package com.deathjack.DeathJack.objectTest;

import com.deathjack.DeathJack.domain.entity.Object;
import com.deathjack.DeathJack.domain.service.impl.ObjectServiceImpl;
import com.deathjack.DeathJack.persistance.repositoryImpl.ObjectRepositoryImpl;
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
public class ObjectMockitoTest {
    @Mock
    ObjectServiceImpl objectService;
    @InjectMocks
    ObjectRepositoryImpl objectRepository;

    @Test
    public void getAllObjects() {
        List<Object> mockObjectList = new ArrayList<>();
        Object mockObject = new Object();
        mockObject.setId(1);
        mockObject.setName("Prueba");
        mockObject.setDescription("Esto es una prueba");
        mockObjectList.add(mockObject);

        Object mockObject2 = new Object();
        mockObject2.setId(2);
        mockObject2.setName("Colores");
        mockObject2.setDescription("Muestra los colores");
        mockObjectList.add(mockObject2);

        when(objectService.getAllObjects()).thenReturn(mockObjectList);

        List<Object> objectList = objectService.getAllObjects();

        assertAll(
                () -> assertEquals(1, objectList.get(0).getId(), "El id no es el correcto"),
                () -> assertEquals("Prueba", objectList.get(0).getName(), "El nombre no es el correcto"),
                () -> assertEquals("Esto es una prueba", objectList.get(0).getDescription(), "La descripcion no es la correcta"),
                () -> assertEquals(2, objectList.get(1).getId(), "El id no es el correcto"),
                () -> assertEquals("Colores", objectList.get(1).getName(), "El nombre no es el correcto"),
                () -> assertEquals("Muestra los colores", objectList.get(1).getDescription(), "La descripcion no es la correcta")
        );

    }

    @Test
    public void getObjectById() {
        Object mockObject = new Object();
        mockObject.setId(1);
        mockObject.setName("Prueba");
        mockObject.setDescription("Esto es una prueba");

        when(objectService.getObjectById(mockObject.getId())).thenReturn(Optional.of(mockObject));

        Optional <Object> object = objectService.getObjectById(1);

        assertAll(
                () -> assertEquals(1, object.get().getId(), "El id no es el correcto"),
                () -> assertEquals("Prueba", object.get().getName(), "El nombre no es el correcto"),
                () -> assertEquals("Esto es una prueba", object.get().getDescription(), "La descripcion no es la correcta")
        );

        Mockito.verify(objectService, Mockito.times(1)).getObjectById(1);
    }
}
