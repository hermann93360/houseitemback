package com.example.houseitem.repository;

import com.example.houseitem.model.ShoppingBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingBackupRepository extends JpaRepository<ShoppingBackup, Long> {
}
