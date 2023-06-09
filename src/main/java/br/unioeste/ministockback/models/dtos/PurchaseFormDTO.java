package br.unioeste.ministockback.models.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseFormDTO {
    private LocalDate date;
    @NotNull
    private Long supplierId;

    @NotNull
    private Double discount;

    @Valid
    @NotEmpty
    private Set<ItemPurchaseFormDTO> items;
}
