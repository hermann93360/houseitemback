package com.example.houseitem.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    public List<String> animalAll(){

        List<String> list = new ArrayList<>();
        list.add("Chien");
        list.add("Chat");
        list.add("Serpent");

        return list;
    }
}
