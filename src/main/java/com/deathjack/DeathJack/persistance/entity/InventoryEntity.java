package com.deathjack.DeathJack.persistance.entity;

public class InventoryEntity {
    private int id;
    private int id_player;
    private int id_object;

    public InventoryEntity () {

    }

    public InventoryEntity (int id, int id_player, int id_object) {
        this.id = id;
        this.id_player = id_player;
        this.id_object = id_object;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId_player() {
        return id_player;
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }

    public int getId_object() {
        return id_object;
    }

    public void setId_object(int id_object) {
        this.id_object = id_object;
    }
}
