package com.example.houseitem.repository;

import com.example.houseitem.model.House;
import com.example.houseitem.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("Select i " +
            "from Item i " +
            "inner join ShoppingType s " +
            "on i.shoppingType.id_shoppingType = s.id_shoppingType " +
            "where i.name like '%?1%'" +
            "and s.id_shoppingType = s.id_shoppingType")
    List<Item> findItemsByNameAndIdShopping(Long id_shopping, String name);

    @Query("select i from Item i where i.id_item = ?1 ")
    Item findByItemId(Long id_item);

    @Query("select i from Item i where i.name = ?1 ")
    Item findByName(String name);
}
