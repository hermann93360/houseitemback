package com.example.houseitem.dto;

public class ShoppingDto {

    private String name;
    private Long id_house;

    public ShoppingDto(){

    }

    public ShoppingDto(String name, Long id_house) {
        this.name = name;
        this.id_house = id_house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_house() {
        return id_house;
    }

    public void setId_house(Long id_house) {
        this.id_house = id_house;
    }
}
