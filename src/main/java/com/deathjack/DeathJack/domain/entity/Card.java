package com.deathjack.DeathJack.domain.entity;

public class Card {
    private int id;
    private String card;

    public Card (int id, String card) {
        this.id = id;
        this.card = card;
    }

    public Card () {
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
