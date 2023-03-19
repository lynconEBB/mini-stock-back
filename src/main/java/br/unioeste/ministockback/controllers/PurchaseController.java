package br.unioeste.ministockback.controllers;

import br.unioeste.ministockback.models.entities.Purchase;
import br.unioeste.ministockback.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("purchase")
public class PurchaseController {

    private final SaleRepository saleRepository;

    private final ModelMapper modelMapper;


/*
    @PostMapping
    public ResponseEntity<Purchase> create(@RequestBody ProductFormDTO productForm) {
        Product productMap = modelMapper.map(productForm, Product.class);
        Set<Type> typesWithId = productForm.getTypesId()
                .stream()
                .map(id -> typeRepository.findById(id).orElse(null))
                .collect(Collectors.toSet());

        productMap.setId(null);
        productMap.setTypes(typesWithId);
        productMap.setAmount(0L);
        Product product = productRepository.save(productMap);
        return ResponseEntity.ok(product);
    }
*/


}
