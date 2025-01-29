package com.deathjack.DeathJack.controller;

import com.deathjack.DeathJack.controller.entity.CreateInventory;
import com.deathjack.DeathJack.controller.entity.InventoryDetailWeb;
import com.deathjack.DeathJack.domain.entity.Inventory;
import com.deathjack.DeathJack.domain.entity.Player;
import com.deathjack.DeathJack.domain.service.InventoryService;
import com.deathjack.DeathJack.domain.service.impl.InventoryServiceImpl;
import com.deathjack.DeathJack.http_response.Response;
import com.deathjack.DeathJack.mapper.InventoryMapper;
import com.deathjack.DeathJack.mapper.PlayerMapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    InventoryService inventoryService = new InventoryServiceImpl();
    @GetMapping("/deathjack/inventory/{playerId}")
    public Response getInventoryByPlayerId(@PathVariable("playerId") int playerId) {
        Inventory inventory = inventoryService.getInventoryByPlayerId(playerId).get();
        InventoryDetailWeb inventoryDetailWeb = InventoryMapper.toInventoryDetailWeb(inventory);
        System.out.println(inventory.getPlayer().getName());
        return new Response(inventoryDetailWeb);
    }

    @PostMapping("/deathjack/inventory/insert")
    public int createInventory(@RequestBody CreateInventory createInventory) {
        return inventoryService.insertInventory(createInventory.getId_player(), createInventory.getId_objet());
    }
}
