package net.boujendar.orderservice.restclients;

import net.boujendar.orderservice.model.product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(url = "http://localhost:8087", name="inventory-service")
public interface InventoryRestClient {
    @GetMapping("/api/products")
    static List<product> getAllProducts() {
        return null;
    }
    @GetMapping("/api/products/{id}")
product findProductById(@PathVariable String id);

}

