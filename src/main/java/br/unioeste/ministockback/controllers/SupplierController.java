package br.unioeste.ministockback.controllers;

import br.unioeste.ministockback.models.entities.Supplier;
import br.unioeste.ministockback.repositories.SupplierRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("supplier")
@CrossOrigin
@Transactional
public class SupplierController {
    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @PostMapping
    public ResponseEntity<Supplier> create(@RequestBody Supplier supplierForm) {
        Supplier supplier = supplierRepository.save(supplierForm);
        return ResponseEntity.ok(supplier);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> list() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable  Long id) {
        Optional<Supplier> supplierOpt = supplierRepository.findById(id);

        if (supplierOpt.isPresent()) {
            return ResponseEntity.ok(supplierOpt.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Supplier supplier, @PathVariable Long id) {
        supplier.setId(id);
        supplierRepository.saveAndFlush(supplier);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
