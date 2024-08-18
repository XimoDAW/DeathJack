package com.deathjack.DeathJack.controller.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatePlayer {
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;

    public CreatePlayer (String name, String password) {
        this.name = name;
        this.password = password;
    }

    public CreatePlayer () {

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
