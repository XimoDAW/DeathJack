package com.deathjack.DeathJack.domain.entity;


import java.util.List;

public class Inventory {
    private int id;
    private Player player;
    private List<Object> objects;


    public Inventory() {

    }

    public Inventory (int id, Player player, List<Object> objects) {
        this.id = id;
        this.player = player;
        this.objects = objects;
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

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
}
