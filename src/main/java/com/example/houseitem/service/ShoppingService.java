package com.example.houseitem.service;

import com.example.houseitem.dto.ShoppingDto;
import com.example.houseitem.model.House;
import com.example.houseitem.model.Item;
import com.example.houseitem.model.Shopping;
import com.example.houseitem.model.ShoppingType;
import com.example.houseitem.repository.HouseRepository;
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

    public ShoppingService() {
    }



    public Shopping addShopping(ShoppingDto shoppingDto){
        if(this.houseRepository.findByHouseId(shoppingDto.getId_house()) == null)
            return null;

        if(this.houseRepository.findByHouseId(shoppingDto.getId_house()).getShoppingType() == null ){
            return null;
        }

        Shopping shopping = new Shopping();
        House house = new House();
        house.setId_house(shoppingDto.getId_house());

        shopping.setName(shoppingDto.getName());
        shopping.setHouse(house);

        return this.shoppingRepository.save(shopping);

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

}
