package net.boujendar.orderservice;

import net.boujendar.orderservice.entities.Order;
import net.boujendar.orderservice.entities.OrderState;
import net.boujendar.orderservice.entities.ProductItem;
import net.boujendar.orderservice.model.product;
import net.boujendar.orderservice.repositories.OrderRepository;
import net.boujendar.orderservice.repositories.ProductItemRepository;
import net.boujendar.orderservice.restclients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderServiceApplication.class, args);
    }
CommandLineRunner commandLineRunner(OrderRepository orderRepository ,
                                    ProductItemRepository productItemRepository,
                                    InventoryRestClient inventoryRestClient){
        return args -> {
//List<product> allProducts =InventoryRestClient.getAllProducts();
            List<String> productsIds= List.of("P01","P02","P03");
for(int i=0;i<5;i++){
    Order order = Order.builder()
            .id(UUID.randomUUID().toString())
            .date(LocalDate.now())
            .state(OrderState.PENDING)
            .build();
}
            LinkedHashMap<Object, Object> allProducts = null;
            productsIds.forEach(pId -> {
    Order Order;
    Order savedOrder = null;
    ProductItem productItem = ProductItem.builder()
            .productId(pId)
            .quantity(new Random().nextInt(20))
            .price(Math.random() * 6000+100)
            .order(savedOrder)
            .build();
    productItemRepository.save(productItem);
});
        };

}
}
