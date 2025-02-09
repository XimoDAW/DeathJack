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

    public int createPlayer (Connection connection, String name, String password) {
        try {
            String sql = "INSERT INTO player (name, password, bot) VALUES (?, ?, ?)";
            int result = DBUtil.insert(connection, sql, List.of(name, password, false));
            String sql2 = "SELECT id FROM player ORDER BY id DESC LIMIT 1";
            ResultSet resultSet = DBUtil.select(connection, sql2, null);
            resultSet.next();
            int id = resultSet.getInt("id");
            String sql3 = "UPDATE player SET id_score = " + id + " WHERE id = ?";
            int result2 = DBUtil.update(connection, sql3, List.of(id));
            return id;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public String updatePlayer (Connection connection, int id, String name, String password) {
        try {
            String sql = "UPDATE player SET name = ?, password = ? WHERE id = ?";
            int result = DBUtil.update(connection, sql, List.of(name, password, id));
            return "Jugador actualizado";
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public String deletePlayer (Connection connection, int id) {
        try {
            String sql = "DELETE FROM player WHERE id = ?";
            int result = DBUtil.delete(connection, sql, List.of(id));
            return "Jugador eliminado";
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
