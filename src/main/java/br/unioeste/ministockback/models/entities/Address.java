package br.unioeste.ministockback.models.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class Address {
    @NotBlank
    private String city;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String state;

    @NotBlank
    private String street;

    @NotNull
    private Integer number;
}
