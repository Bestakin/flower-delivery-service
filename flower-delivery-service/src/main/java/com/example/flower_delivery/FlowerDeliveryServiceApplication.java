package com.example.flower_delivery;

import com.example.flower_delivery.entity.Plant;
import com.example.flower_delivery.repository.PlantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class FlowerDeliveryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlowerDeliveryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(PlantRepository plantRepository) {
        return args -> {
            Plant plant = new Plant();
            plant.setName("Rose");
            plant.setPrice(new BigDecimal("9.99"));
            plantRepository.save(plant);
        };
    }
}