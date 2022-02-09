package com.example.houseitem.service;

import com.example.houseitem.dto.HouseDto;
import com.example.houseitem.exception.ConnectException;
import com.example.houseitem.exception.RegisterException;
import com.example.houseitem.model.House;
import com.example.houseitem.model.ShoppingType;
import com.example.houseitem.repository.HouseRepository;
import com.example.houseitem.repository.ShoppingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ShoppingTypeRepository shoppingTypeRepository;

    @Autowired
    HttpServletResponse response;

    public HouseService() {
    }

    public House addHouse(HouseDto houseDto) throws RegisterException {
        System.out.println(houseDto);
        if(this.houseRepository.findByName(houseDto.getName()) != null)
            throw new RegisterException("Cette maison existe déja");

        House house = new House();

        house.setName(houseDto.getName());
        house.setHouseCode(houseDto.getHouseCode());

        House houseSave = this.houseRepository.save(house);

        ShoppingType shoppingType = new ShoppingType();
        shoppingType.setName("Course type de la maison : " + house.getName());
        shoppingType.setHouse(houseSave);

        this.shoppingTypeRepository.save(shoppingType);

        return houseSave;
    }

    public String connectHouse(HouseDto houseDto) throws ConnectException{
        if(this.houseRepository.findByName(houseDto.getName()) == null)
            throw new ConnectException("La maison n'existe pas");

        House house = this.houseRepository.findByName(houseDto.getName());

        if(houseDto.getHouseCode().equals(house.getHouseCode())){
            this.response.addHeader("identificationHouse", house.getId_house().toString());
            return house.getId_house().toString();
        }

        throw new ConnectException("Le code ne correspont pad ");
    }

}
