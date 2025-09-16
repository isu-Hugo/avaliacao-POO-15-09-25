package com.hz.avaliacao.repository;

import com.hz.avaliacao.entity.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {
}
