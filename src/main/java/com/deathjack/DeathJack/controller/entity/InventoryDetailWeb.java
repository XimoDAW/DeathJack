package com.deathjack.DeathJack.controller.entity;


import java.util.List;

public class InventoryDetailWeb {
    private int id;
    private PlayerDetailWeb playerDetailWeb;
    private List<ObjectDetailWeb> objectsDetailWeb;

    public InventoryDetailWeb() {

    }

    public InventoryDetailWeb(int id, PlayerDetailWeb playerDetailWeb, List<ObjectDetailWeb> objectsDetailWeb) {
        this.id = id;
        this.playerDetailWeb = playerDetailWeb;
        this.objectsDetailWeb = objectsDetailWeb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerDetailWeb getPlayerDetailWeb() {
        return playerDetailWeb;
    }

    public void setPlayerDetailWeb(PlayerDetailWeb playerDetailWeb) {
        this.playerDetailWeb = playerDetailWeb;
    }

    public List<ObjectDetailWeb> getObjectsDetailWeb() {
        return objectsDetailWeb;
    }

    public void setObjectsDetailWeb(List<ObjectDetailWeb> objectsDetailWeb) {
        this.objectsDetailWeb = objectsDetailWeb;
    }
}