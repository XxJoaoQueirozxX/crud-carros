package com.joaoqueiroz.crudcarros.repositories;

import com.joaoqueiroz.crudcarros.domain.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
