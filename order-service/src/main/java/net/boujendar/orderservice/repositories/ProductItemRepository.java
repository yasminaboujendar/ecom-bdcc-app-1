package net.boujendar.orderservice.repositories;

import net.boujendar.orderservice.entities.Order;
import net.boujendar.orderservice.entities.ProductItem;
import org.bouncycastle.pqc.legacy.math.ntru.polynomial.ProductFormPolynomial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long > {


    

}
