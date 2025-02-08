package com.deathjack.DeathJack.domain.service.impl;

import com.deathjack.DeathJack.domain.entity.Inventory;
import com.deathjack.DeathJack.domain.repository.InventoryRepository;
import com.deathjack.DeathJack.domain.service.InventoryService;
import com.deathjack.DeathJack.persistance.repositoryImpl.InventoryRepositoryImpl;

import java.util.Optional;

public class InventoryServiceImpl implements InventoryService {
    InventoryRepository inventoryRepository = new InventoryRepositoryImpl();
    @Override
    public Optional<Inventory> getInventoryByPlayerId(int playerId) {
        Optional <Inventory> inventory = Optional.of(inventoryRepository.getInventoryByPlayerId(playerId).get());
        return Optional.of(inventory.get());
    }

    @Override
    public int insertInventory(int idPlayer, int idObject) {
        return inventoryRepository.insertInventory(idPlayer, idObject);
    }
}
