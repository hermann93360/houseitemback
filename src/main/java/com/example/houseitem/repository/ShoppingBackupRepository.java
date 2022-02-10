package com.example.houseitem.repository;

import com.example.houseitem.model.Shopping;
import com.example.houseitem.model.ShoppingBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingBackupRepository extends JpaRepository<ShoppingBackup, Long> {
    @Query("select s from ShoppingBackup s where s.id_shopping = ?1 ")
    ShoppingBackup findById_shoppingId(Long id_shopping);
}
