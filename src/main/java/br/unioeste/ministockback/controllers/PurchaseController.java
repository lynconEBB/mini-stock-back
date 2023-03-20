package br.unioeste.ministockback.controllers;

import br.unioeste.ministockback.models.dtos.PurchaseFormDTO;
import br.unioeste.ministockback.models.dtos.PurchaseResponseDTO;
import br.unioeste.ministockback.models.entities.ItemPurchase;
import br.unioeste.ministockback.models.entities.Product;
import br.unioeste.ministockback.models.entities.Purchase;
import br.unioeste.ministockback.repositories.ProductRepository;
import br.unioeste.ministockback.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("purchase")
@Transactional
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    private boolean isPurchaseValid(PurchaseFormDTO purchase) {
       if (purchase.getItems().size() == 0)
           return false;

       return true;
    }

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> create(@RequestBody PurchaseFormDTO purchaseForm) {
        Purchase map = modelMapper.map(purchaseForm, Purchase.class);
        map.setId(null);

        Double total = 0.0;
        for (ItemPurchase item : map.getItems()) {
            item.getId().setPurchase(map);
            item.setTotal(item.getPrice() * item.getAmount());

            total += item.getTotal();

            Long productId = item.getId().getProduct().getId();
            Product product = productRepository.findById(productId).orElseThrow();
            item.getId().setProduct(product);

            product.setAmount(product.getAmount() + item.getAmount());
            product.setPurchasePrice(item.getPrice());
            product.setSalePrice(item.getPrice() + (item.getPrice() * 0.15));

            productRepository.save(product);
        }
        map.setTotal(total);
        map.setLiquidPrice(total - (total * (map.getDiscount()/100)));

        map = purchaseRepository.save(map);
        List<PurchaseResponseDTO> purchaseResponse = modelMapper.map(map, new TypeToken<List<PurchaseResponseDTO>>() {
        }.getType());
        return ResponseEntity.ok(purchaseResponse);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseResponseDTO>> get() {
        List<Purchase> purchases = purchaseRepository.findAll();
        List<PurchaseResponseDTO> map = modelMapper.map(purchases, new TypeToken<List<PurchaseResponseDTO>>() {
        }.getType());

        return ResponseEntity.ok(map);
    }
}
