package br.unioeste.ministockback.repositories;

import br.unioeste.ministockback.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByAmountGreaterThan(Long amount);
}
