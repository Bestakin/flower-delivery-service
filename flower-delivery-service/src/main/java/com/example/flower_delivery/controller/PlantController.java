package com.example.flower_delivery.controller;

import com.example.flower_delivery.entity.Plant;
import com.example.flower_delivery.entity.PlantDTO;
import com.example.flower_delivery.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping("/dto")
    public PlantDTO getPlantDTO(@RequestParam String name) {
        Plant plant = plantService.getPlantByName(name);
        return plantService.convertToDTO(plant);
    }
    @GetMapping("/filtered")
    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(@RequestParam String name) {
        return plantService.getPlantByName(name);
    }

    // Optional backup converter
    private PlantDTO convertPlantToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        org.springframework.beans.BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }
    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price) {
        return plantService.findPlantsBelowPrice(price);
    }
}
