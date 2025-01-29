package com.deathjack.DeathJack.domain.entity;


public class Inventory {
    private int id;
    private Player player;
    private Object object;


    public Inventory() {

    }

    public Inventory (int id, Player player, Object object) {
        this.id = id;
        this.player = player;
        this.object = object;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
