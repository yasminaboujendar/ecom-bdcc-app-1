package net.boujendar.orderservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import net.boujendar.orderservice.model.product;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
@ToString
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private double price;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    private int quantity;
    @Transient
    private product product;

}
