package com.sbk.api.repository;

import com.sbk.api.domain.corretor.CorretorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorretorRepository extends JpaRepository<CorretorModel, Long> {
}
