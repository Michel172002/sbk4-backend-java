package com.sbk.api.repository;

import com.sbk.api.domain.imoveis.ImovelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<ImovelModel, Long> {
}
