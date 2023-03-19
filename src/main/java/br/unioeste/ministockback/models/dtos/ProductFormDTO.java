package br.unioeste.ministockback.models.dtos;

import br.unioeste.ministockback.models.entities.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFormDTO {
    private String barCode;

    private String name;

    Long supplierId;

    Set<Long> typesId;
}
