package com.deathjack.DeathJack.persistance.repositoryImpl;

import com.deathjack.DeathJack.ddbb.DBUtil;
import com.deathjack.DeathJack.domain.entity.Inventory;
import com.deathjack.DeathJack.domain.entity.Object;
import com.deathjack.DeathJack.domain.repository.InventoryRepository;
import com.deathjack.DeathJack.mapper.ObjectMapper;
import com.deathjack.DeathJack.mapper.PlayerMapper;
import com.deathjack.DeathJack.persistance.dao.InventoryDAO;
import com.deathjack.DeathJack.persistance.dao.ObjectDAO;
import com.deathjack.DeathJack.persistance.dao.PlayerDAO;
import com.deathjack.DeathJack.persistance.entity.InventoryEntity;
import com.deathjack.DeathJack.persistance.entity.ObjectEntity;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryRepositoryImpl implements InventoryRepository {
    InventoryDAO inventoryDAO = new InventoryDAO();
    PlayerDAO playerDAO = new PlayerDAO();
    ObjectDAO objectDAO = new ObjectDAO();
    @Override
    public Optional<Inventory> getInventoryByPlayerId(int playerId) {
        try (Connection connection = DBUtil.open(true)){
            List<InventoryEntity> inventoryEntityList = inventoryDAO.getInventoryByIdPlayer(connection, playerId);
            Inventory inventory = new Inventory();
            if (!inventoryEntityList.isEmpty()) {
                PlayerEntity playerEntity = playerDAO.getPlayerById(connection, inventoryEntityList.get(0).getId_player()).get();
                List<ObjectEntity> objectEntityList = new ArrayList<>();

                inventoryEntityList.stream().map(
                        inventoryEntity -> {
                            return objectEntityList.add(objectDAO.getObjectById(connection, inventoryEntity.getId_object()).get());
                        }
                ).toList();
                inventory.setId(playerId);
                inventory.setPlayer(PlayerMapper.toPlayer(playerEntity));

                List<Object> objectList = new ArrayList<>();

                objectEntityList.stream().map(
                        objectEntity -> {
                            return objectList.add(ObjectMapper.toObject(objectEntity));
                        }
                ).toList();
                inventory.setObjects(objectList);
            }
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

    @Override
    public String deleteObjectInInventory(int playerId, int objectId) {
        try (Connection connection = DBUtil.open(true)) {
            return inventoryDAO.deleteObjectInInventory(connection, playerId, objectId);
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
