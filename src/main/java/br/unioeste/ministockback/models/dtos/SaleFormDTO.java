package br.unioeste.ministockback.models.dtos;

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
public class SaleFormDTO {

    private LocalDate date;

    @NotNull
    private Long customerId;

    @NotNull
    private Double discount;

    private PaymentMethod paymentMethod;
    @Valid
    @NotEmpty
    private Set<ItemSaleFormDTO> items;

}
