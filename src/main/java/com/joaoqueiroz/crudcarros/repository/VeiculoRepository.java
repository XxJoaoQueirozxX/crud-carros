package com.joaoqueiroz.crudcarros.repository;

import com.joaoqueiroz.crudcarros.domain.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
