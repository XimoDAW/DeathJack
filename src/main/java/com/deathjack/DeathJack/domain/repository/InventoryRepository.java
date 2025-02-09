package com.deathjack.DeathJack.domain.repository;

import com.deathjack.DeathJack.domain.entity.Inventory;
import com.deathjack.DeathJack.domain.entity.Player;

import java.util.Optional;

public interface InventoryRepository {
    public Optional<Inventory> getInventoryByPlayerId(int playerId);
    public int insertInventory(int playerId, int objectId);
    public String deleteObjectInInventory(int playerId, int objectId);
}
