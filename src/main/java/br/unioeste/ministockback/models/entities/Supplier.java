package br.unioeste.ministockback.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cnpj;

    @Embedded
    private Address address;
}
