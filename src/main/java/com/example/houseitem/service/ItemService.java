package com.example.houseitem.service;

import com.example.houseitem.dto.ItemDto;
import com.example.houseitem.model.Item;
import com.example.houseitem.repository.HouseRepository;
import com.example.houseitem.repository.ItemRepository;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private HouseRepository houseRepository;

    public ItemService() {
    }

    public Boolean addItem(ItemDto itemDto){
        if(this.houseRepository.findHouseById(itemDto.getId_house()) == null)
            return false;

        Item item = new Item();

        item.setId_house(itemDto.getId_house());
        item.setName(itemDto.getName());
        item.setQuantity(itemDto.getQuantity());

        return this.itemRepository.save(item) != null;
    }

    public List<Item> getItemsByIdHouse(Long id_house){
        return null;
    }

    public boolean RemoveOneItem(Long id_item){
        return false;
    }

    public boolean addOneItem(Long id_item){
        return false;
    }

    public List<Item> generateList(){
        return null;
    }



}
