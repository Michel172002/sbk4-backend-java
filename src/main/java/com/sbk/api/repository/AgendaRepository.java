package com.sbk.api.repository;

import com.sbk.api.domain.agenda.AgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaModel, Long> {
}
