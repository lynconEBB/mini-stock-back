package br.unioeste.ministockback.controllers;

import br.unioeste.ministockback.models.entities.Customer;
import br.unioeste.ministockback.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customerForm) {
        try {
            Customer customer = customerService.create(customerForm);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
//            return ResponseEntity.badRequest().build();
        }
    }
}
