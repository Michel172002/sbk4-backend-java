package com.sbk.api.domain.proprietario;

import com.sbk.api.domain.identificacao.Identificacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProprietarioDto (
        @NotBlank
        String nome,
        @NotNull
        LocalDate nascimento,
        @NotNull
        Boolean sexo,
        @NotBlank
        String telefone,
        @NotBlank
        String email,
        @NotNull
        Identificacao identificacao,
        @NotBlank
        String identificacaoNumero,
        @NotBlank
        String observacao
) {
}
