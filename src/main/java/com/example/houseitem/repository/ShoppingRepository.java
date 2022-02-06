package com.example.houseitem.repository;

import com.example.houseitem.model.Shopping;
import com.example.houseitem.model.ShoppingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingRepository extends JpaRepository<Shopping, Long> {
    @Query("select s from Shopping s where s.id_shopping = ?1 ")
    Shopping findByShoppingId(Long id_shopping);
}
