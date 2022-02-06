package com.example.houseitem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_house;

    @Column
    private String name;

    @Column
    private String houseCode;

    @OneToMany
    @JoinTable(name = "house_item",
            joinColumns = @JoinColumn(name = "id_house"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))
    @JsonIgnore
    private List<Item> item = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "shopping_house",
            joinColumns = @JoinColumn(name = "id_house"),
            inverseJoinColumns = @JoinColumn(name = "id_shopping"))
    @JsonIgnore
    private List<Shopping> shopping = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "shoppingBackup_house",
            joinColumns = @JoinColumn(name = "id_house"),
            inverseJoinColumns = @JoinColumn(name = "id_shoppingBackup"))
    @JsonIgnore
    private List<ShoppingBackup> shoppingBackup = new ArrayList<>();

    @OneToOne
    @JoinTable(name = "shoppingType_house",
            joinColumns = @JoinColumn(name = "id_house"),
            inverseJoinColumns = @JoinColumn(name = "id_shoppingType"))
    @JsonIgnore
    private ShoppingType shoppingType;

    public House() {
    }

    public House(Long id_house, String name, String houseCode, List<Item> item, List<Shopping> shopping, List<ShoppingBackup> shoppingBackup, ShoppingType shoppingType) {
        this.id_house = id_house;
        this.name = name;
        this.houseCode = houseCode;
        this.item = item;
        this.shopping = shopping;
        this.shoppingBackup = shoppingBackup;
        this.shoppingType = shoppingType;
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

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public List<Shopping> getShopping() {
        return shopping;
    }

    public void setShopping(List<Shopping> shopping) {
        this.shopping = shopping;
    }

    public List<ShoppingBackup> getShoppingBackup() {
        return shoppingBackup;
    }

    public void setShoppingBackup(List<ShoppingBackup> shoppingBackup) {
        this.shoppingBackup = shoppingBackup;
    }

    public ShoppingType getShoppingType() {
        return shoppingType;
    }

    public void setShoppingType(ShoppingType shoppingType) {
        this.shoppingType = shoppingType;
    }
}
