package br.unioeste.ministockback.repositories;

import br.unioeste.ministockback.models.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
