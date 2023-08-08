package com.sbk.api.domain.atividade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtividadeDto (
        @NotNull
        Long idImovel,
        @NotNull
        Long idCliente,
        @NotNull
        Boolean ativo,
        @NotNull
        int vencimento,
        @NotNull
        Situacao situacao
) {
}
