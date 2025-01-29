package com.deathjack.DeathJack.controller.entity;


public class InventoryDetailWeb {
    private int id;
    private PlayerDetailWeb playerDetailWeb;
    private ObjectDetailWeb objectDetailWeb;

    public InventoryDetailWeb() {

    }

    public InventoryDetailWeb(int id, PlayerDetailWeb playerDetailWeb, ObjectDetailWeb objectDetailWeb) {
        this.id = id;
        this.playerDetailWeb = playerDetailWeb;
        this.objectDetailWeb = objectDetailWeb;
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

    public ObjectDetailWeb getObjectDetailWeb() {
        return objectDetailWeb;
    }

    public void setObjectDetailWeb(ObjectDetailWeb objectDetailWeb) {
        this.objectDetailWeb = objectDetailWeb;
    }
}
