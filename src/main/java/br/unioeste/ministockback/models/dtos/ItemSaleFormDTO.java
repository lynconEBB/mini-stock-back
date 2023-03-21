package br.unioeste.ministockback.models.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemSaleFormDTO {
    @NotNull
    private Long productId;

    @NotNull
    @DecimalMin(value = "0",inclusive = false)
    private Long amount;
}
