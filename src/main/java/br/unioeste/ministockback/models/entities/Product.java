package br.unioeste.ministockback.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String barCode;

    private String name;

    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;

    private String imagePath;

    private Double PurchasePrice;

    private Double SalePrice;

    @ManyToOne
    Supplier supplier;

    @ManyToMany
    Set<Type> type;
}