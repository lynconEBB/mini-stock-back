package br.unioeste.ministockback.models.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ItemPurchase {

    @EmbeddedId
    private ItemPurchaseId id;

    private Long amount = 0L;

    private Double price;

    private Double total;
}
