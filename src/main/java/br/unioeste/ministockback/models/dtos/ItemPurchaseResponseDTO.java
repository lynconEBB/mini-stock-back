package br.unioeste.ministockback.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPurchaseResponseDTO {
    private Long idProductId;

    private String idProductName;

    private Long amount;

    private Double price;

    private Double total;
}