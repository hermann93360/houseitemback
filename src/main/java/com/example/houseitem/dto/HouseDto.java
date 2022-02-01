package com.example.houseitem.dto;

public class HouseDto {

    private String name;
    private String houseCode;

    public HouseDto() {
    }

    public HouseDto(String name, String houseCode) {
        this.name = name;
        this.houseCode = houseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }
}
