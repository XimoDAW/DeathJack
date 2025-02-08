package com.deathjack.DeathJack.mapper;

import com.deathjack.DeathJack.controller.entity.CreateInventory;
import com.deathjack.DeathJack.controller.entity.InventoryDetailWeb;
import com.deathjack.DeathJack.controller.entity.ObjectDetailWeb;
import com.deathjack.DeathJack.domain.entity.Inventory;
import com.deathjack.DeathJack.domain.entity.Object;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.persistance.entity.InventoryEntity;
import com.deathjack.DeathJack.persistance.entity.ObjectEntity;
import com.deathjack.DeathJack.persistance.entity.PlayerEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public static Inventory toInventory (InventoryEntity inventoryEntity, PlayerEntity playerEntity, List<ObjectEntity> objectEntityList) {
        try {
            Inventory inventory = new Inventory();
            inventory.setId(inventoryEntity.getId());
            inventory.setPlayer(PlayerMapper.toPlayer(playerEntity));
            List<Object> objectList = new ArrayList<>();

            objectEntityList.stream().map(
                    objectEntity -> {
                        return objectList.add(ObjectMapper.toObject(objectEntity));
                    }
                    ).
                    toList();

            inventory.setObjects(objectList);
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
            List<ObjectDetailWeb> objectDetailWebList = new ArrayList<>();
            inventory.getObjects().stream().map(
                    object -> {
                        return objectDetailWebList.add(ObjectMapper.toObjectDetailWeb(object));
                    }
                    ).
                    toList();
            inventoryDetailWeb.setObjectsDetailWeb(objectDetailWebList);
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
