package com.sbk.api.repository;

import com.sbk.api.domain.proprietario.ProprietarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends JpaRepository<ProprietarioModel, Long> {

}
