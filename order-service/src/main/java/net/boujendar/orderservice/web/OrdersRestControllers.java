package net.boujendar.orderservice.web;

import net.boujendar.orderservice.entities.Order;
import net.boujendar.orderservice.repositories.OrderRepository;
import net.boujendar.orderservice.restclients.InventoryRestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersRestControllers {
    private OrderRepository orderRepository;
    private InventoryRestClient inventoryRestClient;
    public OrdersRestControllers(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public List<Order> findAll(){
        List<Order> allOrders = orderRepository.findAll();
        allOrders.forEach(order -> {
            order.getProductItems().forEach(productItem -> {
                productItem.setProduct(inventoryRestClient.findProductById(productItem.getProductId()));
            });
        });
        return allOrders;
    }
    @GetMapping("/orders/{id}")
    public Order findOrderById(@PathVariable String id){
        Order order =orderRepository.findById(id).get();
        order.getProductItems().forEach(productItem -> {
            productItem.setProduct(inventoryRestClient.findProductById(productItem.getProductId()));
        });
        return order ;
    }
}
