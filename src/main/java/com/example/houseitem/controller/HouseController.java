package com.example.houseitem.controller;

import com.example.houseitem.dto.HouseDto;
import com.example.houseitem.model.House;
import com.example.houseitem.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping(value = "/house/add")
    public ResponseEntity<House> addHouse(@RequestBody HouseDto houseDto){
        return ResponseEntity.ok(this.houseService.addHouse(houseDto));
    }

    @PostMapping(value = "/house/connect")
    public ResponseEntity<String> connectHouse(@RequestBody HouseDto houseDto){
        return ResponseEntity.ok(this.houseService.connectHouse(houseDto));
    }

}
