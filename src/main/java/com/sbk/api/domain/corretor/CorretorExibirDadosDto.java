package com.sbk.api.domain.corretor;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public record CorretorExibirDadosDto(
        Long id,
        String nome,
        String telefone,
        String creci,
        Boolean ativo,
        LocalDateTime createAt,
        LocalDateTime lastUpdate
) {
    public CorretorExibirDadosDto(CorretorModel dados){
        this(dados.getId(), dados.getNome(), dados.getTelefone(), dados.getCreci(), dados.getAtivo(), dados.getCreateAt(), dados.getLastUpdate());
    }
}
