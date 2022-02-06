package com.example.houseitem.model;

import com.example.houseitem.repository.HouseRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shopping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id_shopping;

    protected String name;

    @OneToMany
    @JoinTable(name = "shopping_item",
            joinColumns = @JoinColumn(name = "id_shopping"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))
    @JsonIgnore
    protected List<Item> item = new ArrayList<>();

    @ManyToOne
    @JoinTable(name = "shopping_house",
            joinColumns = @JoinColumn(name = "id_shopping"),
            inverseJoinColumns = @JoinColumn(name = "id_house"))
    protected House house;

    public Shopping() {
    }

    public Shopping(Long id_shopping, String name, List<Item> item, House house) {
        this.id_shopping = id_shopping;
        this.name = name;
        this.item = item;
        this.house = house;
    }

    public Long getId_shopping() {
        return id_shopping;
    }

    public void setId_shopping(Long id_shopping) {
        this.id_shopping = id_shopping;
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
