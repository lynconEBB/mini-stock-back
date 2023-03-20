package br.unioeste.ministockback.models.dtos;

import br.unioeste.ministockback.models.entities.ItemPurchase;
import br.unioeste.ministockback.models.entities.Supplier;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponseDTO {
    private Long id;

    private LocalDate date;

    private Supplier supplier;

    private Double total;

    private Double liquidPrice;

    private Double discount;

    private Set<ItemPurchaseResponseDTO> items;
}
