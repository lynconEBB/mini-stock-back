package br.unioeste.ministockback.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Supplier supplier;

    private Double total;

    private Double liquidPrice;

    private Double discount;

    @OneToMany(mappedBy = "id.purchase")
    private Set<ItemPurchase> items;
}
