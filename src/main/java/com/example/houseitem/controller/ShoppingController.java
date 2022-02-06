package com.example.houseitem.controller;

import com.example.houseitem.dto.HouseDto;
import com.example.houseitem.dto.ShoppingDto;
import com.example.houseitem.exception.RegisterException;
import com.example.houseitem.model.House;
import com.example.houseitem.model.Shopping;
import com.example.houseitem.model.ShoppingType;
import com.example.houseitem.repository.HouseRepository;
import com.example.houseitem.service.HouseService;
import com.example.houseitem.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(origins = "*")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @PostMapping(value = "/shopping/type/add")
    public ResponseEntity<ShoppingType> addShoppingType(@RequestBody ShoppingDto shoppingDto){
        return ResponseEntity.ok(this.shoppingService.addShoppingType(shoppingDto));
    }

    @PostMapping(value = "/shopping/add")
    public ResponseEntity<Shopping> addShopping(@RequestBody ShoppingDto shoppingDto){
        return ResponseEntity.ok(this.shoppingService.addShopping(shoppingDto));
    }
}
