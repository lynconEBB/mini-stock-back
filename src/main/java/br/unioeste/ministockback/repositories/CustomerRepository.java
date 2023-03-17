package br.unioeste.ministockback.repositories;

import br.unioeste.ministockback.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
