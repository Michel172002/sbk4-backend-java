package com.sbk.api.domain.agenda;

import com.sbk.api.domain.cliente.ClienteExibirDadosDto;
import com.sbk.api.domain.corretor.CorretorExibirDadosDto;
import com.sbk.api.domain.imoveis.ImovelExibirDadosDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AgendaExibirDadosDto(
        Long id,
        LocalDate dia,
        LocalTime hora,
        String informacoes,
        Boolean aprovado,
        Status status,
        CorretorExibirDadosDto corretor,
        ClienteExibirDadosDto cliente,
        ImovelExibirDadosDto imovel,
        LocalDateTime createAt,
        LocalDateTime lastUpdate
) {
    public AgendaExibirDadosDto(AgendaModel dados){
        this(dados.getId(), dados.getDia(), dados.getHora(), dados.getInformacoes(), dados.getAprovado(),
                dados.getStatus(), new CorretorExibirDadosDto(dados.getCorretor()),
                new ClienteExibirDadosDto(dados.getCliente()), new ImovelExibirDadosDto(dados.getImovel()),
                dados.getCreateAt(), dados.getLastUpdate());
    }
}
