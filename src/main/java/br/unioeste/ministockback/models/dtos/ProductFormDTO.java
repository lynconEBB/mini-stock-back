package br.unioeste.ministockback.models.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFormDTO {

    @NotBlank
    private String barCode;

    @NotBlank
    private String name;

    @NotNull
    Long supplierId;

    @Min(1)
    Set<Long> typesId;
}
