package com.sbk.api.domain.proprietario;

import com.sbk.api.domain.identificacao.Identificacao;

import java.time.LocalDate;

public record ProprietarioEditarDadosDto(
        String nome,
        LocalDate nascimento,
        Boolean sexo,
        String telefone,
        String email,
        Identificacao identificacao,
        String identificacaoNumero,
        String observacao
) {
}
