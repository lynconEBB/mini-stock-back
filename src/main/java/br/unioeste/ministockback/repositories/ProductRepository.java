package br.unioeste.ministockback.repositories;

import br.unioeste.ministockback.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
