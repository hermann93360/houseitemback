package com.example.houseitem.service;

import com.example.houseitem.dto.ShoppingDto;
import com.example.houseitem.model.*;
import com.example.houseitem.repository.HouseRepository;
import com.example.houseitem.repository.ShoppingBackupRepository;
import com.example.houseitem.repository.ShoppingRepository;
import com.example.houseitem.repository.ShoppingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ShoppingTypeRepository shoppingTypeRepository;

    @Autowired
    private ShoppingBackupRepository shoppingBackupRepository;


    public ShoppingService() {
    }

    public Shopping addShopping(ShoppingDto shoppingDto){
        if(this.houseRepository.findByHouseId(shoppingDto.getId_house()) == null)
            return null;

        Shopping shopping = new Shopping();
        House house = new House();
        house.setId_house(shoppingDto.getId_house());

        shopping.setName(shoppingDto.getName());
        shopping.setHouse(house);

        Shopping shopSave = this.shoppingRepository.save(shopping);

        ShoppingBackup shoppingBackup = new ShoppingBackup();
        shoppingBackup.setId_shopping(shopSave.getId_shopping());
        shoppingBackup.setArchived(false);
        shoppingBackup.setName(shopSave.getName());

        this.shoppingBackupRepository.save(shoppingBackup);

        return shopSave;
    }

    public ShoppingType addShoppingType(ShoppingDto shoppingDto){
        if(this.houseRepository.findByHouseId(shoppingDto.getId_house()) == null)
            return null;

        ShoppingType shoppingType = new ShoppingType();
        House house = new House();
        house.setId_house(shoppingDto.getId_house());

        shoppingType.setName(shoppingDto.getName());
        shoppingType.setHouse(house);

        return this.shoppingTypeRepository.save(shoppingType);
    }

    public ShoppingType getShoppingType(Long id_house){
        return this.houseRepository.findByHouseId(id_house).getShoppingType();
    }

    public List<Shopping> getShopping(Long id_house){
        return this.houseRepository.findByHouseId(id_house).getShopping();
    }

}
