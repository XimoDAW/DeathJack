package com.deathjack.DeathJack.controller.entity;

public class CardListWeb {
    private int id;
    private String card;

    public CardListWeb (int id, String card) {
        this.id = id;
        this.card = card;
    }

    public CardListWeb () {
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
