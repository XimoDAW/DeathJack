package com.deathjack.DeathJack.controller.entity;

public class ObjectListWeb {
    private int id;
    private String name;

    public ObjectListWeb (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectListWeb () {

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
