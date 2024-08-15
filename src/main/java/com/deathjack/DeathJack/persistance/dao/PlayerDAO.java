package com.deathjack.DeathJack.persistance.dao;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.mapper.PlayerMapper;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class PlayerDAO {
    public Optional <PlayerEntity> getById(Connection connection, int id) {
        try {
            String sql = "SELECT * FROM player WHERE id = ?";
            ResultSet resultSet = DBUtil.select(connection, sql, List.of(id));
            resultSet.next();
            PlayerEntity playerEntity = PlayerMapper.toPlayerEntity(resultSet);
            return Optional.of(playerEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
