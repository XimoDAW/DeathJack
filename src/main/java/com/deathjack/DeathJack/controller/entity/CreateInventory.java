package com.deathjack.DeathJack.controller.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class CreateInventory {
    @JsonProperty("id_player")
    private int id_player;
    @JsonProperty("id_object")
    private int id_objet;

    public CreateInventory () {

    }

    public CreateInventory (int id_player, int id_object) {
        this.id_player = id_player;
        this.id_objet = id_object;
    }


    public int getId_player() {
        return id_player;
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }

    public int getId_objet() {
        return id_objet;
    }

    public void setId_objet(int id_objet) {
        this.id_objet = id_objet;
    }
}
