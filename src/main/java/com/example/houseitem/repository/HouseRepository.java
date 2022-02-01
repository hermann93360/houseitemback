package com.example.houseitem.repository;

import com.example.houseitem.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    House findByName(String name);

    @Query(value = "select h from House h where h.id_house = ?1")
    House findHouseById(Long id_house);

    House findByHouseCode(String houseCode);
}
