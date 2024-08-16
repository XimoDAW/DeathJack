package com.deathjack.DeathJack.persistance.dao;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.mapper.ObjectMapper;
import com.deathjack.DeathJack.mapper.PlayerMapper;
import com.deathjack.DeathJack.persistance.entity.ObjectEntity;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ObjectDAO {

    public List<ObjectEntity> getAllObjects(Connection connection) {
        try {
            String sql = "SELECT * FROM object";
            ResultSet resultSet = DBUtil.select(connection, sql, null);
            List<ObjectEntity> objectEntityList = new ArrayList<>();

            while (resultSet.next()) {
                ObjectEntity objectEntity = ObjectMapper.toObjectEntity(resultSet);
                objectEntityList.add(objectEntity);
            }

            return objectEntityList;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
