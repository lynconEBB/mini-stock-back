package br.unioeste.ministockback.controllers;

import br.unioeste.ministockback.models.dtos.SaleFormDTO;
import br.unioeste.ministockback.models.dtos.SaleResponseDTO;
import br.unioeste.ministockback.models.entities.ItemSale;
import br.unioeste.ministockback.models.entities.Product;
import br.unioeste.ministockback.models.entities.Sale;
import br.unioeste.ministockback.repositories.ProductRepository;
import br.unioeste.ministockback.repositories.SaleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sale")
@RequiredArgsConstructor
@Transactional
public class SaleController {
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<SaleResponseDTO> create(@RequestBody @Valid SaleFormDTO saleForm) {
        Sale sale = modelMapper.map(saleForm, Sale.class);
        sale.setId(null);

        double total = 0.0;
        for(ItemSale item : sale.getItems()) {
            item.getId().setSale(sale);

            Long productId = item.getId().getProduct().getId();
            Product product = productRepository.findById(productId).orElseThrow();
            item.getId().setProduct(product);

            if (product.getAmount() < item.getAmount())
                throw new RuntimeException("Produto sem estoque necessário");

            product.setAmount(product.getAmount() - item.getAmount());
            item.setPrice(product.getSalePrice());
            item.setTotal(item.getPrice() * item.getAmount());
            total += item.getTotal();

            productRepository.save(product);
        }

        sale.setTotal(total);
        sale.setLiquidPrice(total - (total * (sale.getDiscount()/100)));
        sale = saleRepository.save(sale);

        SaleResponseDTO saleResponse = modelMapper.map(sale, SaleResponseDTO.class);

        return ResponseEntity.ok(saleResponse);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> list() {

        List<Sale> sales = saleRepository.findAll();
        List<SaleResponseDTO> salesResponse = modelMapper.map(sales, new TypeToken<List<SaleResponseDTO>>() {
        }.getType());

        return ResponseEntity.ok(salesResponse);
    }
}
