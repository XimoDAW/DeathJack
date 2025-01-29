package com.deathjack.DeathJack.persistance.dao;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.mapper.InventoryMapper;
import com.deathjack.DeathJack.persistance.entity.InventoryEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryDAO {
    public Optional<InventoryEntity> getInventoryByIdPlayer(Connection connection, int id) {
        try {
            String sql = "SELECT * FROM inventory WHERE id_player = ?";
            ResultSet resultSet = DBUtil.select(connection, sql, List.of(id));
            resultSet.next();
            InventoryEntity inventoryEntity = InventoryMapper.toInventoryEntity(resultSet);
            return Optional.of(inventoryEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public int insertInventory (Connection connection, int playerId, int objectId) {
        try {
            String sql = "INSERT INTO inventory (id_player, id_object) VALUES (?, ?)";
            int result = DBUtil.insert(connection, sql, List.of(playerId, objectId));
            return result;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public String updateInventory (Connection connection, int id, String name, String password) {
        try {
            String sql = "UPDATE inventory SET name = ?, password = ? WHERE id = ?";
            int result = DBUtil.update(connection, sql, List.of(name, password, id));
            return "Jugador actualizado";
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
