package com.deathjack.DeathJack.controller.entity;

import com.deathjack.DeathJack.domain.entity.Player;

public class PlayerListWeb {
    private int id;
    private String name;

    public PlayerListWeb (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlayerListWeb () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
