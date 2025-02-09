package com.deathjack.DeathJack.domain.service.impl;

import com.deathjack.DeathJack.domain.entity.Inventory;
import com.deathjack.DeathJack.domain.repository.InventoryRepository;
import com.deathjack.DeathJack.domain.repository.ObjectRepository;
import com.deathjack.DeathJack.domain.service.InventoryService;
import com.deathjack.DeathJack.http_error.DuplicateObjectException;
import com.deathjack.DeathJack.persistance.repositoryImpl.InventoryRepositoryImpl;
import com.deathjack.DeathJack.persistance.repositoryImpl.ObjectRepositoryImpl;

import java.util.Optional;

public class InventoryServiceImpl implements InventoryService {
    InventoryRepository inventoryRepository = new InventoryRepositoryImpl();
    ObjectRepository objectRepository = new ObjectRepositoryImpl();
    @Override
    public Optional<Inventory> getInventoryByPlayerId(int playerId) {
        Optional <Inventory> inventory = Optional.of(inventoryRepository.getInventoryByPlayerId(playerId).get());
        return Optional.of(inventory.get());
    }

    @Override
    public int insertInventory(int idPlayer, int idObject) {
        try {
            Optional <Inventory> inventory = getInventoryByPlayerId(idPlayer);
            boolean isDuplicate = false;
            if (inventory.get().getId() != 0) {
                for (int i = 0; i < inventory.get().getObjects().size(); i++) {
                    if (inventory.get().getObjects().get(i).getId() == idObject) {
                        isDuplicate = true;
                        i = inventory.get().getObjects().size();
                    }
                }

                if (isDuplicate) {
                    throw new DuplicateObjectException("El objeto ya esta en el inventario del jugador");
                }
                }
            return inventoryRepository.insertInventory(idPlayer, idObject);
        }catch (DuplicateObjectException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public String deleteObjectInInventory(int idPlayer, int idObject) {
        return inventoryRepository.deleteObjectInInventory(idPlayer, idObject);
    }
}
