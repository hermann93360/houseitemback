package com.example.houseitem.repository;

import com.example.houseitem.model.House;
import com.example.houseitem.model.ShoppingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingTypeRepository extends JpaRepository<ShoppingType, Long> {
    @Query("select s from ShoppingType s where s.id_shoppingType = ?1 ")
    ShoppingType findByShoppingTypeId(Long id_shoppingType);

}
