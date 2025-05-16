package net.boujendar.inventoryservice.repositories;

import net.boujendar.inventoryservice.entities.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product, String> {

}
