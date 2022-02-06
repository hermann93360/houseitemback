package com.example.houseitem.model;

import com.example.houseitem.repository.HouseRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingBackup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_shoppingBackup;

    private String name;

    @OneToMany
    @JoinTable(name = "shoppingBackup_item",
            joinColumns = @JoinColumn(name = "id_shoppingBackup"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))
    @JsonIgnore
    private List<Item> item = new ArrayList<>();

    @ManyToOne
    @JoinTable(name = "shoppingBackup_house",
            joinColumns = @JoinColumn(name = "id_shoppingBackup"),
            inverseJoinColumns = @JoinColumn(name = "id_house"))
    private House house;

    private String price;

    public ShoppingBackup() {
    }

    public ShoppingBackup(Long id_shoppingBackup, String name, List<Item> item, House house, String price) {
        this.id_shoppingBackup = id_shoppingBackup;
        this.name = name;
        this.item = item;
        this.house = house;
        this.price = price;
    }

    public Long getId_shoppingBackup() {
        return id_shoppingBackup;
    }

    public void setId_shoppingBackup(Long id_shoppingBackup) {
        this.id_shoppingBackup = id_shoppingBackup;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
