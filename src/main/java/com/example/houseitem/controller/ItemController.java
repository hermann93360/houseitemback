package com.example.houseitem.controller;

import com.example.houseitem.dto.HouseDto;
import com.example.houseitem.dto.ItemDto;
import com.example.houseitem.model.House;
import com.example.houseitem.model.Item;
import com.example.houseitem.repository.HouseRepository;
import com.example.houseitem.service.HouseService;
import com.example.houseitem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/item/add")
    public ResponseEntity<Boolean> addUser(@RequestBody ItemDto itemDto){
        return ResponseEntity.ok(this.itemService.addItem(itemDto));
    }

    @GetMapping(value = "/items/{id_house}")
    public ResponseEntity<List<Item>> addUser(@PathVariable Long id_house){
        return ResponseEntity.ok(this.itemService.getItemsByIdHouse(id_house));
    }

}
