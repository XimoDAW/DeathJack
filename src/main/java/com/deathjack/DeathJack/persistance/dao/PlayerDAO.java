package com.deathjack.DeathJack.persistance.dao;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.mapper.PlayerMapper;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerDAO {
    public Optional <PlayerEntity> getPlayerById(Connection connection, int id) {
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

    public List<PlayerEntity> getAllPlayers (Connection connection) {
        try {
            String sql = "SELECT * FROM player";
            ResultSet resultSet = DBUtil.select(connection, sql, null);
            List<PlayerEntity> playerEntityList = new ArrayList<>();

            while (resultSet.next()) {
                PlayerEntity playerEntity = PlayerMapper.toPlayerEntity(resultSet);
                playerEntityList.add(playerEntity);
            }

            return playerEntityList;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public int createPlayer (Connection connection, String name, String password, int id_score) {
        try {
            String sql = "INSERT INTO player (id_score, name, password) VALUES (?, ?, ?)";
            int result = DBUtil.insert(connection, sql, List.of(id_score, name, password));
            return 1;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
