package com.example.houseitem.service;

import com.example.houseitem.dto.ItemDto;
import com.example.houseitem.model.House;
import com.example.houseitem.model.Item;
import com.example.houseitem.model.Shopping;
import com.example.houseitem.model.ShoppingType;
import com.example.houseitem.repository.HouseRepository;
import com.example.houseitem.repository.ItemRepository;
import com.example.houseitem.repository.ShoppingRepository;
import com.example.houseitem.repository.ShoppingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ShoppingTypeRepository shoppingTypeRepository;

    @Autowired
    private ShoppingRepository shoppingRepository;

    public ItemService() {
    }

    public boolean addItemInHouse(ItemDto itemDto){
        if(this.houseRepository.findByHouseId(itemDto.getId_house()) == null)
            return false;

        Item item = new Item();
        House house = new House();
        house.setId_house(itemDto.getId_house());

        item.setHouse(house);
        item.setName(itemDto.getName());
        item.setQuantity(itemDto.getQuantity());

        return this.itemRepository.save(item) != null;
    }

    //Add item in shopping type list for generate shopping list
    public boolean addItemInShoppingListType(ItemDto itemDto){
        if(this.shoppingTypeRepository.findByShoppingTypeId(itemDto.getId_shopping()) == null)
            return false;

        Item item = new Item();
        ShoppingType shoppingType = new ShoppingType();
        shoppingType.setId_shoppingType(itemDto.getId_shopping());

        item.setShoppingType(shoppingType);
        item.setName(itemDto.getName());
        item.setQuantity(itemDto.getQuantity());

        return this.itemRepository.save(item) != null;

    }

    public List<Item> getItemsShoppingTypeByIdHouse(Long id_house){
        return this.houseRepository.findByHouseId(id_house).getShoppingType().getItem();
    }

    public List<Item> getItemsByIdHouse(Long id_house){
        return null;
    }

    public boolean generateShoppingList(Long id_house, Long id_shopping){

        Shopping shopping = this.shoppingRepository.findByShoppingId(id_shopping);

        List<Item> itemInHouse = this.getItemsByIdHouse(id_house);
        List<Item> itemShoppingType = this.getItemsShoppingTypeByIdHouse(id_house);

        List<Item> generateList = new ArrayList<Item>();

        boolean itemFind;
        for (Item itemShop: itemShoppingType){
            itemFind = false;
            for(Item itemHouse: itemInHouse){
                if(itemShop.getName().equalsIgnoreCase(itemHouse.getName())){
                    if(itemShop.getQuantity() > itemHouse.getQuantity()){
                        Item item = new Item();
                        item.setQuantity(itemShop.getQuantity() - itemHouse.getQuantity());
                        item.setShopping(shopping);
                        item.setShoppingBackup(null);
                        item.setShoppingType(null);
                        item.setHouse(null);
                        this.itemRepository.save(item);
                        generateList.add(item);
                    }
                    itemFind = true;
                }
            }
            if(!itemFind){
                Item item = new Item();
                item.setShopping(shopping);
                item.setShoppingBackup(null);
                item.setShoppingType(null);
                item.setHouse(null);
                this.itemRepository.save(item);
                generateList.add(itemShop);
            }
        }

        return true;
    }

    public boolean removeOneItem(Long id_item){
        return false;
    }

    public boolean addOneItem(Long id_item){
        return false;
    }

    public boolean removeItem(Long id_item){
        return false;
    }
}
