package com.deathjack.DeathJack.persistance.entity;

public class CardEntity {
    private int id;
    private String card;

    public CardEntity (int id, String card) {
        this.id = id;
        this.card = card;
    }

    public CardEntity () {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
