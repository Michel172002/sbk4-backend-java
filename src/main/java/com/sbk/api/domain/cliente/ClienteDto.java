package com.sbk.api.domain.cliente;

import com.sbk.api.domain.identificacao.Identificacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteDto(
        @NotBlank
        String nome,
        @NotNull
        LocalDate dataNas,
        @NotNull
        Boolean sexo,
        @NotBlank
        String telefone,
        @NotBlank
        String email,
        @NotNull
        Identificacao identificacao,
        @NotBlank
        String identificacaoNumber,
        @NotBlank
        String observacao,
        @NotBlank
        String procTipo,
        @NotNull
        Boolean procAlugando,
        @NotBlank
        String procComodos
) {
}
