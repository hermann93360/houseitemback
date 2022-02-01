package com.example.houseitem.controller;

import com.example.houseitem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/animal")
    public ResponseEntity<List<String>> animal(){
        List<String> list = itemService.animalAll();

        return ResponseEntity.ok(list);
    }


}
