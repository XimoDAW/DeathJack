package com.deathjack.DeathJack.mapper;

import com.deathjack.DeathJack.controller.entity.ObjectDetailWeb;
import com.deathjack.DeathJack.controller.entity.ObjectListWeb;
import com.deathjack.DeathJack.persistance.entity.ObjectEntity;

import com.deathjack.DeathJack.domain.entity.Object;

import java.sql.ResultSet;

public class ObjectMapper {
    public static ObjectEntity toObjectEntity(ResultSet resultSet) {
        try {
            ObjectEntity objectEntity = new ObjectEntity();
            objectEntity.setId(resultSet.getInt("id"));
            objectEntity.setName(resultSet.getString("name"));
            objectEntity.setDescription(resultSet.getString("description"));
            return objectEntity;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public static Object toObject(ObjectEntity objectEntity) {
        try {
            Object object = new Object();
            object.setId(objectEntity.getId());
            object.setName(objectEntity.getName());
            object.setDescription(objectEntity.getDescription());
            return object;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public static ObjectDetailWeb toObjectDetailWeb (Object object) {
        try {
            ObjectDetailWeb objectDetailWeb = new ObjectDetailWeb();
            objectDetailWeb.setId(object.getId());
            objectDetailWeb.setName(object.getName());
            objectDetailWeb.setDescription(object.getDescription());
            return objectDetailWeb;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public static ObjectListWeb toObjectListWeb (Object object) {
        try {
            ObjectListWeb objectListWeb = new ObjectListWeb();
            objectListWeb.setId(object.getId());
            objectListWeb.setName(object.getName());
            return objectListWeb;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
