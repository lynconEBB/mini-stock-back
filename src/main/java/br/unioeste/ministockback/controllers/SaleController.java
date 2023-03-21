package br.unioeste.ministockback.controllers;

import br.unioeste.ministockback.models.dtos.SaleFormDTO;
import br.unioeste.ministockback.repositories.SaleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sale")
@RequiredArgsConstructor
public class SaleController {
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SaleFormDTO saleForm) {

        return ResponseEntity.ok().build();

    }
}
