package com.deathjack.DeathJack.domain.service;

import com.deathjack.DeathJack.domain.entity.Inventory;

import java.util.Optional;

public interface InventoryService {
    public Optional<Inventory> getInventoryByPlayerId(int playerId);
    public int insertInventory(int idPlayer, int idObject);
    public String deleteObjectInInventory(int idPlayer, int idObject);
}
