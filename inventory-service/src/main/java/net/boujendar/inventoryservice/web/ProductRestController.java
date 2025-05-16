package net.boujendar.inventoryservice.web;

import net.boujendar.inventoryservice.entities.product;
import net.boujendar.inventoryservice.repositories.ProductRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductRestController {
    private ProductRepository productRepository;
    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/products")
    //@PreAuthorize("hasAuthority('ADMIN') ")
    public List<product> productList(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    //@PreAuthorize("hasAuthority('USER') ")
    public product productById(@PathVariable String id){
        return productRepository.findById(id).get();
    }
@GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
