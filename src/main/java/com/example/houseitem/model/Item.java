package com.example.houseitem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_item;

    @Column
    private String name;

    @Column
    private int quantity;

    @Column
    private Long id_house;

    public Item() {
    }

    public Item(Long id_item, String name, int quantity, Long id_house) {
        this.id_item = id_item;
        this.name = name;
        this.quantity = quantity;
        this.id_house = id_house;
    }

    public Long getId_item() {
        return id_item;
    }

    public void setId_item(Long id_item) {
        this.id_item = id_item;
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
}
