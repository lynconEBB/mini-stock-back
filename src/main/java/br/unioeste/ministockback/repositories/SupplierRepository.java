package br.unioeste.ministockback.repositories;

import br.unioeste.ministockback.models.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
