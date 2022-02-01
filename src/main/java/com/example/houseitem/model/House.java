package com.example.houseitem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_house;

    @Column
    private String name;

    @Column
    private String houseCode;

    public House() {
    }

    public House(Long id_house, String name, String houseCode) {
        this.id_house = id_house;
        this.name = name;
        this.houseCode = houseCode;
    }

    public Long getId_house() {
        return id_house;
    }

    public void setId_house(Long id_house) {
        this.id_house = id_house;
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

    @Override
    public String toString() {
        return "House{" +
                "id_house=" + id_house +
                ", name='" + name + '\'' +
                ", houseCode='" + houseCode + '\'' +
                '}';
    }
}
