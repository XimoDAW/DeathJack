package com.deathjack.DeathJack.persistance.repositoryImpl;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.domain.entity.Inventory;
import com.deathjack.DeathJack.domain.repository.InventoryRepository;
import com.deathjack.DeathJack.mapper.InventoryMapper;
import com.deathjack.DeathJack.persistance.dao.InventoryDAO;
import com.deathjack.DeathJack.persistance.dao.ObjectDAO;
import com.deathjack.DeathJack.persistance.dao.PlayerDAO;

import java.sql.Connection;
import java.util.Optional;

public class InventoryRepositoryImpl implements InventoryRepository {
    InventoryDAO inventoryDAO = new InventoryDAO();
    PlayerDAO playerDAO = new PlayerDAO();
    ObjectDAO objectDAO = new ObjectDAO();
    @Override
    public Optional<Inventory> getInventoryByPlayerId(int playerId) {
        try (Connection connection = DBUtil.open(true)){
            Inventory inventory = InventoryMapper.toInventory(inventoryDAO.getInventoryByIdPlayer(connection, playerId).get(),
            playerDAO.getPlayerById(connection, playerId).get(),
            objectDAO.getObjectById(connection, inventoryDAO.getInventoryByIdPlayer(connection, playerId).get().getId_object()).get());
            return Optional.of(inventory);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public int insertInventory(int playerId, int objectId) {
        try (Connection connection = DBUtil.open(true)) {
            return inventoryDAO.insertInventory(connection, playerId, objectId);
        }catch (Exception e){
            throw new RuntimeException("Error");
        }
    }
}
