package br.unioeste.ministockback.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPurchaseFormDTO {
    private Long productId;

    private Long amount;

    private Double price;
}
