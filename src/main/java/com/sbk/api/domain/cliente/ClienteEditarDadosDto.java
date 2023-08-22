package com.sbk.api.domain.cliente;

import com.sbk.api.domain.identificacao.Identificacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteEditarDadosDto (
        String nome,
        LocalDate dataNas,
        Boolean sexo,
        String telefone,
        String email,
        Identificacao identificacao,
        String identificacaoNumber,
        String observacao,
        String procTipo,
        Boolean procAlugando,
        String procComodos,
        Boolean ativo
) {

}
