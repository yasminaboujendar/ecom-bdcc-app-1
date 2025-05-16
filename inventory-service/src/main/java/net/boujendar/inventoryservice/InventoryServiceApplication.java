package net.boujendar.inventoryservice;

import net.boujendar.inventoryservice.entities.product;
import net.boujendar.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(product.builder().id("P01").name("Computer").price(2300).quantity(5)
                    .build());
            productRepository.save(product.builder().id("P02").name("Printer").price(1200).quantity(18)
                    .build());
            productRepository.save(product.builder().id("P03").name("Smart Phone ").price(1800).quantity(10)
                    .build());

        };
    }
}
