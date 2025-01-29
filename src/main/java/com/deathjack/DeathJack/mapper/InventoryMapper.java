package com.deathjack.DeathJack.mapper;

import com.deathjack.DeathJack.controller.entity.CreateInventory;
import com.deathjack.DeathJack.controller.entity.InventoryDetailWeb;
import com.deathjack.DeathJack.domain.entity.Inventory;
import com.deathjack.DeathJack.domain.entity.Object;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.persistance.entity.InventoryEntity;
import com.deathjack.DeathJack.persistance.entity.ObjectEntity;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;

import java.sql.ResultSet;

public class InventoryMapper {
    public static InventoryEntity toInventoryEntity (ResultSet resultSet) {
        try {
            InventoryEntity inventoryEntity = new InventoryEntity();
            inventoryEntity.setId(resultSet.getInt("id"));
            inventoryEntity.setId_player(resultSet.getInt("id_player"));
            inventoryEntity.setId_object(resultSet.getInt("id_object"));
            return inventoryEntity;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }

    }

    public static Inventory toInventory (InventoryEntity inventoryEntity, PlayerEntity playerEntity, ObjectEntity objectEntity) {
        try {
            Inventory inventory = new Inventory();
            inventory.setId(inventoryEntity.getId());
            inventory.setPlayer(PlayerMapper.toPlayer(playerEntity));
            inventory.setObject(ObjectMapper.toObject(objectEntity));
            return inventory;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }

    }

    public static InventoryDetailWeb toInventoryDetailWeb (Inventory inventory) {
        try {
            InventoryDetailWeb inventoryDetailWeb = new InventoryDetailWeb();
            inventoryDetailWeb.setId(inventory.getId());
            inventoryDetailWeb.setPlayerDetailWeb(PlayerMapper.toPlayerDetailWeb(inventory.getPlayer()));
            inventoryDetailWeb.setObjectDetailWeb(ObjectMapper.toObjectDetailWeb(inventory.getObject()));
            return inventoryDetailWeb;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    /*
    public static Inventory toInventory (int id, UpdateInventory updateInventory) {
        try {
            Inventory inventory = new Inventory();

            inventory.setId(id);
            inventory.setId_score(0);
            inventory.setName(updateInventory.getName());
            inventory.setPassword(updateInventory.getPassword());
            inventory.setBot(false);
            return inventory;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }

    }

    public static InventoryDetailWeb toInventoryDetailWeb (Inventory inventory) {
        try {
            InventoryDetailWeb inventoryDetailWeb = new InventoryDetailWeb();

            inventoryDetailWeb.setId(inventory.getId());
            inventoryDetailWeb.setId_score(inventory.getId_score());
            inventoryDetailWeb.setName(inventory.getName());
            inventoryDetailWeb.setPassword(inventory.getPassword());
            inventoryDetailWeb.setBot(inventory.isBot());
            return inventoryDetailWeb;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public static InventoryListWeb toInventoryListWeb (Inventory inventory) {
        try {
            InventoryListWeb inventoryListWeb = new InventoryListWeb();

            inventoryListWeb.setId(inventory.getId());
            inventoryListWeb.setName(inventory.getName());
            return inventoryListWeb;
        }catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }*/
}
