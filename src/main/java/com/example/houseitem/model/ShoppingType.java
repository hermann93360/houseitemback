package com.example.houseitem.model;

import com.example.houseitem.repository.HouseRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id_shoppingType;

    protected String name;

    @OneToMany
    @JoinTable(name = "shoppingType_item",
            joinColumns = @JoinColumn(name = "id_shoppingType"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))
    @JsonIgnore
    protected List<Item> item = new ArrayList<>();

    @ManyToOne
    @JoinTable(name = "shoppingType_house",
            joinColumns = @JoinColumn(name = "id_shoppingType"),
            inverseJoinColumns = @JoinColumn(name = "id_house"))
    protected House house;

    public ShoppingType() {
    }

    public ShoppingType(Long id_shoppingType, String name, List<Item> item, House house) {
        this.id_shoppingType = id_shoppingType;
        this.name = name;
        this.item = item;
        this.house = house;
    }

    public Long getId_shoppingType() {
        return id_shoppingType;
    }

    public void setId_shoppingType(Long id_shoppingType) {
        this.id_shoppingType = id_shoppingType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

}
