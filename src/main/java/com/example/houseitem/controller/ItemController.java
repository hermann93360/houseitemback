package com.example.houseitem.controller;

import com.example.houseitem.dto.HouseDto;
import com.example.houseitem.dto.ItemDto;
import com.example.houseitem.model.House;
import com.example.houseitem.model.Item;
import com.example.houseitem.repository.HouseRepository;
import com.example.houseitem.repository.ItemRepository;
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
    private ItemRepository itemRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/item/add")
    public ResponseEntity<Boolean> addItemInHouse(@RequestBody ItemDto itemDto){
        return ResponseEntity.ok(this.itemService.addItemInHouse(itemDto));
    }

    @PostMapping(value = "/item/shopping/type/add")
    public ResponseEntity<Boolean> addItemInShoppingListType(@RequestBody ItemDto itemDto){
        return ResponseEntity.ok(this.itemService.addItemInShoppingListType(itemDto));
    }

    @PostMapping(value = "/item/shopping/add/{id_house}/{id_shopping}")
    public ResponseEntity<Boolean> addItemGenerateInShoppingList(@PathVariable Long id_house, @PathVariable Long id_shopping){
        return ResponseEntity.ok(this.itemService.generateShoppingList(id_house, id_shopping));
    }

    @GetMapping(value = "/items/{id_house}")
    public ResponseEntity<List<Item>> itemsByHouse(@PathVariable Long id_house){
        return ResponseEntity.ok(this.itemService.getItemsByIdHouse(id_house));
    }


}
