package com.sbk.api.domain.agenda;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendaDto(
        @NotNull
        Long idCorretor,
        @NotNull
        Long idCliente,
        @NotNull
        Long idImovel,
        @NotNull
        LocalDate dia,
        @NotNull
        LocalTime hora,
        @NotBlank
        String informacoes,
        @NotNull
        Boolean aprovado,
        @NotNull
        Status status
) {
}
