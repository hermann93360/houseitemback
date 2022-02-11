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

    @PostMapping(value = "/item/shopping/add")
    public ResponseEntity<Item> addItemInShopping(@RequestBody ItemDto itemDto){
        return ResponseEntity.ok(this.itemService.addItemInShopping(itemDto));
    }

    @GetMapping(value = "/items/shopping/type/items/{id_house}")
    public ResponseEntity<List<Item>> itemsByShoppingTypeList(@PathVariable Long id_house){
        return ResponseEntity.ok(this.itemService.getItemsShoppingTypeByIdHouse(id_house));
    }

    @GetMapping(value = "/items/shopping/type/{id_shopping}/{name}")
    public ResponseEntity<List<Item>> itemsByShoppingTypeAndName(@PathVariable Long id_shopping, @PathVariable String name){
        return ResponseEntity.ok(this.itemService.getItemsByNameAndIdShoppingType(id_shopping, name));
    }

    @GetMapping(value = "/items/shopping/{id_shopping}/{name}")
    public ResponseEntity<List<Item>> itemsByShoppingAndName(@PathVariable Long id_shopping, @PathVariable String name){
        return ResponseEntity.ok(this.itemService.getItemsByNameAndIdShopping(id_shopping, name));
    }

    @GetMapping(value = "/items/shopping/{id_shopping}")
    public ResponseEntity<List<Item>> itemsByShopping(@PathVariable Long id_shopping){
        return ResponseEntity.ok(this.itemService.getItemByShopping(id_shopping));
    }


    @GetMapping(value = "/items/{id_house}/{name}")
    public ResponseEntity<List<Item>> itemsByHouseAndName(@PathVariable Long id_house, @PathVariable String name){
        return ResponseEntity.ok(this.itemService.getItemsByName(id_house, name));
    }

    @GetMapping(value = "/item/shopping/generate/{id_house}/{id_shopping}")
    public ResponseEntity<List<Item>> addItemGenerateInShoppingList(@PathVariable Long id_house, @PathVariable Long id_shopping){
        return ResponseEntity.ok(this.itemService.generateShoppingList(id_house, id_shopping));
    }

    @GetMapping(value = "/items/{id_house}")
    public ResponseEntity<List<Item>> getItemsByHouse(@PathVariable Long id_house){
        return ResponseEntity.ok(this.itemService.getItemsByIdHouse(id_house));
    }

    @GetMapping(value = "/items/buy/{id_shopping}")
    public ResponseEntity<List<Item>> getItemsBuy(@PathVariable Long id_shopping){
        return ResponseEntity.ok(this.itemService.getItemBuy(id_shopping));
    }

    @PutMapping(value = "/items/{id_item}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id_item, @RequestBody ItemDto itemDto){
        return ResponseEntity.ok(this.itemService.updateItem(id_item, itemDto));
    }

    @DeleteMapping(value = "/items/{id_item}")
    public ResponseEntity<Item> removeItem(@PathVariable Long id_item){
        return ResponseEntity.ok(this.itemService.removeItem(id_item));
    }


}
