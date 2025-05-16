package net.boujendar.inventoryservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor@AllArgsConstructor @Getter
@Setter @Builder @ToString
public class product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
