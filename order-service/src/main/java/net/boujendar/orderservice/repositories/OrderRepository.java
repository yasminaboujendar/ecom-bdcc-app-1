package net.boujendar.orderservice.repositories;

import net.boujendar.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String > {


}
