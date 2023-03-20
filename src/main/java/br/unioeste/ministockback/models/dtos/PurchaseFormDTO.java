package br.unioeste.ministockback.models.dtos;

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
    private Long supplierId;

    private Double discount;

    private Set<ItemPurchaseFormDTO> items;
}
