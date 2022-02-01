package com.example.houseitem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class ItemController {



    @GetMapping(value = "/test")
    public ResponseEntity<String> test(){
        String string = new String("OK Sa marche");
        return ResponseEntity.ok(string);
    }


}
