package br.unioeste.ministockback.models.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    private String city;

    private String neighborhood;

    private String state;

    private String street;

    private Integer number;

}
