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

    private Long amount;

    private String imagePath;

    private Double purchasePrice;

    private Double salePrice;

    @ManyToOne
    Supplier supplier;

    @ManyToMany
    Set<Type> types;
}