package br.unioeste.ministockback.controllers;

import br.unioeste.ministockback.models.dtos.ProductFormDTO;
import br.unioeste.ministockback.models.entities.Product;
import br.unioeste.ministockback.models.entities.Supplier;
import br.unioeste.ministockback.models.entities.Type;
import br.unioeste.ministockback.repositories.ProductRepository;
import br.unioeste.ministockback.repositories.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
@CrossOrigin
@Transactional
@RequiredArgsConstructor
public class ProductController {

    private final ModelMapper modelMapper;

    private final ProductRepository productRepository;

    private final TypeRepository typeRepository;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductFormDTO productForm) {
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

    @GetMapping
    public ResponseEntity<List<Product>> list() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable  Long id) {
        Optional<Product> productOpt = productRepository.findById(id);

        if (productOpt.isPresent()) {
            return ResponseEntity.ok(productOpt.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ProductFormDTO productForm, @PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow();

        Set<Type> typesWithId = productForm.getTypesId()
                .stream()
                .map(typeId -> typeRepository.findById(typeId).orElse(null))
                .collect(Collectors.toSet());

        product.setName(productForm.getName());
        product.setBarCode(productForm.getBarCode());
        product.setSupplier(new Supplier(productForm.getSupplierId()));
        product.setTypes(typesWithId);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}