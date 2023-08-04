package com.sbk.api.domain.cliente;

import com.sbk.api.domain.identificacao.Identificacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteExibirDadosDto(
        Long id,
        String nome,
        LocalDate dataNasm,
        String telefone,
        String email,
        Identificacao identificacao,
        String identificacaoNumber,
        String observacao,
        String procTipo,
        Boolean procAlugando,
        String procComodos,
        Boolean ativo,
        LocalDateTime createAt,
        LocalDateTime lastUpdate
) {
    public ClienteExibirDadosDto(ClienteModel dados){
        this(dados.getId(), dados.getNome(), dados.getDataNas(), dados.getTelefone(), dados.getEmail(), dados.getIdentificacao(), dados.getIdentificacaoNumber(), dados.getObservacao(), dados.getProcTipo(), dados.getProcAlugando(), dados.getProcComodos(), dados.getAtivo(), dados.getCreateAt(), dados.getLastUpdate());
    }
}
