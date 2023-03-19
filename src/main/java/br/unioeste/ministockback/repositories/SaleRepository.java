package br.unioeste.ministockback.repositories;

import br.unioeste.ministockback.models.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
