package com.deathjack.DeathJack.controller.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePlayer {
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;

    public UpdatePlayer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UpdatePlayer () {

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
}
