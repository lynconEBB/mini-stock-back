package br.unioeste.ministockback.models.dtos;

import br.unioeste.ministockback.models.entities.Customer;
import br.unioeste.ministockback.models.entities.PaymentMethod;
import jakarta.validation.Valid;
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
public class SaleResponseDTO {
    private Long id;

    private LocalDate date;

    private Customer customer;

    private Double discount;

    private Double total;

    private Double liquidPrice;

    private PaymentMethod paymentMethod;

    private Set<ItemSaleResponseDTO> items;
}
