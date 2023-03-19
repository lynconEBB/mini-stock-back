package br.unioeste.ministockback.repositories;

import br.unioeste.ministockback.models.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
