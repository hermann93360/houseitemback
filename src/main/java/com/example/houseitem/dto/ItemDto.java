package com.example.houseitem.dto;

public class ItemDto {

    private String name;
    private int quantity;
    private Long id_house;
    private Long id_shopping;

    public ItemDto() {
    }

    public ItemDto(String name, int quantity, Long id_house, Long id_shopping) {
        this.name = name;
        this.quantity = quantity;
        this.id_house = id_house;
        this.id_shopping = id_shopping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId_house() {
        return id_house;
    }

    public void setId_house(Long id_house) {
        this.id_house = id_house;
    }

    public Long getId_shopping() {
        return id_shopping;
    }

    public void setId_shopping(Long id_shopping) {
        this.id_shopping = id_shopping;
    }
}
