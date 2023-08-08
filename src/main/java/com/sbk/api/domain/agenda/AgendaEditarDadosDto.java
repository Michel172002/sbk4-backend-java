package com.sbk.api.domain.agenda;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendaEditarDadosDto(
        Long idCorretor,
        Long idCliente,
        Long idImovel,
        LocalDate dia,
        LocalTime hora,
        String informacoes,
        Boolean aprovado,
        Status status
) {
}
