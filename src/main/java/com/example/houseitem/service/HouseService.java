package com.example.houseitem.service;

import com.example.houseitem.dto.HouseDto;
import com.example.houseitem.model.House;
import com.example.houseitem.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    HttpServletResponse response;

    public HouseService() {
    }

    public House addHouse(HouseDto houseDto){

        if(this.houseRepository.findByName(houseDto.getName()) != null)
            return null;

        House house = new House();

        house.setName(houseDto.getName());
        house.setHouseCode(houseDto.getHouseCode());

        return this.houseRepository.save(house);
    }

    public String connectHouse(HouseDto houseDto){
        if(this.houseRepository.findByName(houseDto.getName()) == null)
            return null;

        House house = this.houseRepository.findByName(houseDto.getName());

        if(houseDto.getHouseCode().equals(house.getHouseCode())){
            this.response.addHeader("identificationHouse", house.getId_house().toString());
            return house.getId_house().toString();
        }

        return null;
    }

}
