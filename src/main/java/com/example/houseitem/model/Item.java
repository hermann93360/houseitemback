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

    @ManyToOne
    @JoinTable(name = "house_item",
            joinColumns = @JoinColumn(name = "id_item"),
            inverseJoinColumns = @JoinColumn(name = "id_house"))
    private House house;

    @ManyToOne
    @JoinTable(name = "shopping_item",
            joinColumns = @JoinColumn(name = "id_item"),
            inverseJoinColumns = @JoinColumn(name = "id_shopping"))
    private Shopping shopping;

    @ManyToOne
    @JoinTable(name = "shoppingType_item",
            joinColumns = @JoinColumn(name = "id_item"),
            inverseJoinColumns = @JoinColumn(name = "id_shoppingType"))
    private ShoppingType shoppingType;

    @ManyToOne
    @JoinTable(name = "shoppingBackup_item",
            joinColumns = @JoinColumn(name = "id_item"),
            inverseJoinColumns = @JoinColumn(name = "id_shoppingBackup"))
    private ShoppingBackup shoppingBackup;

    public Item() {
    }

    public Item(Long id_item, String name, int quantity, House house, Shopping shopping, ShoppingType shoppingType, ShoppingBackup shoppingBackup) {
        this.id_item = id_item;
        this.name = name;
        this.quantity = quantity;
        this.house = house;
        this.shopping = shopping;
        this.shoppingType = shoppingType;
        this.shoppingBackup = shoppingBackup;
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

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Shopping getShopping() {
        return shopping;
    }

    public void setShopping(Shopping shopping) {
        this.shopping = shopping;
    }

    public ShoppingType getShoppingType() {
        return shoppingType;
    }

    public void setShoppingType(ShoppingType shoppingType) {
        this.shoppingType = shoppingType;
    }

    public ShoppingBackup getShoppingBackup() {
        return shoppingBackup;
    }

    public void setShoppingBackup(ShoppingBackup shoppingBackup) {
        this.shoppingBackup = shoppingBackup;
    }

}
