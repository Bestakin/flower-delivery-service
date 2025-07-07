package com.example.flower_delivery.service;

import com.example.flower_delivery.entity.Plant;
import com.example.flower_delivery.entity.PlantDTO;
import com.example.flower_delivery.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public Plant getPlantByName(String name){
        return plantRepository.findByName(name); // fetches actual plant from DB
    }

    public PlantDTO convertToDTO(Plant plant) {
        return new PlantDTO(plant.getName(), plant.getPrice());
    }

    public Long save(Plant plant){
        return plantRepository.save(plant).getId();
    }

    public Boolean delivered(Long id){
        // return plantRepository.deliveryCompleted(id);
        return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }
}
