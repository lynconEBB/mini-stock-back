package br.unioeste.ministockback.controllers;


import br.unioeste.ministockback.models.entities.Type;
import br.unioeste.ministockback.repositories.TypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("type")
@CrossOrigin
@Transactional
public class TypeController {

    private final TypeRepository typeRepository;

    public TypeController(TypeRepository supplierRepository) {
        this.typeRepository = supplierRepository;
    }

    @PostMapping
    public ResponseEntity<Type> create(@RequestBody Type typeForm) {
        Type type = typeRepository.save(typeForm);
        return ResponseEntity.ok(type);
    }

    @GetMapping
    public ResponseEntity<List<Type>> list() {
        List<Type> types = typeRepository.findAll();
        return ResponseEntity.ok(types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable  Long id) {
        Optional<Type> typeOpt = typeRepository.findById(id);

        if (typeOpt.isPresent()) {
            return ResponseEntity.ok(typeOpt.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Type type, @PathVariable Long id) {
        type.setId(id);
        typeRepository.saveAndFlush(type);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        typeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
