package com.example.houseitem.service;

import com.example.houseitem.dto.ItemDto;
import com.example.houseitem.model.*;
import com.example.houseitem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    @Autowired
    private ShoppingBackupRepository shoppingBackupRepository;

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

    public Item addItemInShopping(ItemDto itemDto){
        if(this.shoppingRepository.findByShoppingId(itemDto.getId_shopping()) == null)
            return null;

        if(itemDto.getQuantity() == 0){
        }

        ShoppingBackup shopSave = this.shoppingBackupRepository.findById_shoppingId(itemDto.getId_shopping());
        Shopping shopping = this.shoppingRepository.findByShoppingId(itemDto.getId_shopping());

        Item item = new Item();

        item.setShoppingBackup(shopSave);
        item.setShopping(shopping);
        item.setName(itemDto.getName());
        item.setQuantity(itemDto.getQuantity());

        return this.itemRepository.save(item);
    }

    public List<Item> getItemsShoppingTypeByIdHouse(Long id_house){
        return this.houseRepository.findByHouseId(id_house).getShoppingType().getItem();
    }

    public List<Item> getItemsByName(Long id_house, String name){
       return containsSubString(this.houseRepository.findByHouseId(id_house).getItem(), name);
    }

    public List<Item> getItemsByNameAndIdShoppingType(Long id_shopping, String name) {
        return containsSubString(this.shoppingTypeRepository.findByShoppingTypeId(id_shopping).getItem(), name);
    }

    public List<Item> getItemsByNameAndIdShopping(Long id_shopping, String name) {
        return containsSubString(this.shoppingRepository.findByShoppingId(id_shopping).getItem(), name);
    }

    private List<Item> containsSubString(List<Item> items, String name){

        return (items != null || name != null ) ? items.stream()
                .filter(item -> item.getName() != null && item.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList()) : null;
    }


    public List<Item> getItemsByIdHouse(Long id_house){
        return this.houseRepository.findByHouseId(id_house).getItem();
    }

    public List<Item> generateShoppingList(Long id_house, Long id_shopping){

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
                        item.setName(itemHouse.getName());
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
                item.setName(itemShop.getName());
                item.setQuantity(itemShop.getQuantity());
                item.setShoppingBackup(null);
                item.setShoppingType(null);
                item.setHouse(null);
                this.itemRepository.save(item);
                generateList.add(itemShop);
            }
        }

        return generateList;
    }

    public List<Item> getItemByShopping(Long id_shopping){
        return this.shoppingRepository.findByShoppingId(id_shopping).getItem();
    }

    public Item updateItem(Long id_item, ItemDto itemDto){
        if(this.itemRepository.findByItemId(id_item) == null)
            return null;

        Item item = this.itemRepository.findByItemId(id_item);

        item.setName(itemDto.getName());
        item.setQuantity(itemDto.getQuantity());

        return this.itemRepository.save(item);
    }

    public Item removeOneItem(Long id_item){
        if(this.itemRepository.findByItemId(id_item) == null)
            return null;

        Item item = this.itemRepository.findByItemId(id_item);

        if(item.getQuantity() - 1 > 0)
            item.setQuantity(item.getQuantity() - 1);
        else
            this.removeItem(id_item);

        return this.itemRepository.save(item);
    }

    public Item addOneItem(Long id_item){
        if(this.itemRepository.findByItemId(id_item) == null)
            return null;

        Item item = this.itemRepository.findByItemId(id_item);

        item.setQuantity(item.getQuantity() + 1);

        return this.itemRepository.save(item);
    }

    public Item removeItem(Long id_item){
        Item item = this.itemRepository.findByItemId(id_item);
        this.itemRepository.deleteById(id_item);

        return item;
    }
}
