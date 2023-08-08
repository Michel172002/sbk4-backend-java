package com.sbk.api.repository;

import com.sbk.api.domain.atividade.AtividadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<AtividadeModel, Long> {
}
