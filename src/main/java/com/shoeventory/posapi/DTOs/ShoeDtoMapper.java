package com.shoeventory.posapi.DTOs;


import com.shoeventory.posapi.domain.Shoe;
import org.springframework.stereotype.Service;

@Service
public class ShoeDtoMapper {

    public ShoeDto mapToDto(Shoe shoe) {
        return new ShoeDto(
                shoe.getId(),
                shoe.getManufacturer(),
                shoe.getType(),
                shoe.getName(),
                shoe.getColor(),
                shoe.getSize(),
                shoe.getQuantity(),
                shoe.getPrice()
        );
    }
}