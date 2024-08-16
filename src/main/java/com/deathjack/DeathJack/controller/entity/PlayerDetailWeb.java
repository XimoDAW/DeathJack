package com.deathjack.DeathJack.controller.entity;

public class PlayerDetailWeb {
    private int id;
    private int id_score;
    private String name;
    private String password;
    private boolean bot;

    public PlayerDetailWeb (int id, int id_score, String name, String password, boolean bot) {
        this.id = id;
        this.id_score = id_score;
        this.name = name;
        this.password = password;
        this.bot = bot;
    }

    public PlayerDetailWeb () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_score() {
        return id_score;
    }

    public void setId_score(int id_score) {
        this.id_score = id_score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }
}
