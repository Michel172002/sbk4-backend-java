package com.sbk.api.domain.proprietario;

import com.sbk.api.domain.identificacao.Identificacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ProprietarioExibirDadosDto(
        Long id,
        String nome,
        LocalDate nascimento,
        Boolean sexo,
        String telefone,
        String email,
        Identificacao identificacao,
        String identificacaoNumero,
        String observacao,
        LocalDateTime createAt,
        LocalDateTime lastUpdate
) {
    public ProprietarioExibirDadosDto(ProprietarioModel dados){
        this(dados.getId(), dados.getNome(), dados.getNascimento(), dados.getSexo(), dados.getTelefone(), dados.getEmail(), dados.getIdentificacao(), dados.getIdentificacaoNumero(), dados.getObservacao(), dados.getCreateAt(), dados.getLastUpdate());
    }
}
