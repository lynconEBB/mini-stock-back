package br.unioeste.ministockback.models.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}|\\d{3}.\\d{3}.\\d{3}-\\d")
    private String document;

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4}-\\d{4}")
    private String phone;

    @Embedded
    @Valid
    private Address address;
}
