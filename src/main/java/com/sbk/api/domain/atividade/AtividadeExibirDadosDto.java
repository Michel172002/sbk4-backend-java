package com.sbk.api.domain.atividade;

import com.sbk.api.domain.cliente.ClienteExibirDadosDto;
import com.sbk.api.domain.imoveis.ImovelExibirDadosDto;
import com.sbk.api.domain.imoveis.ImovelModel;

import java.time.LocalDateTime;

public record AtividadeExibirDadosDto(
        Long id,
        ImovelExibirDadosDto imovel,
        ClienteExibirDadosDto cliente,
        Boolean ativo,
        int vencimento,
        Situacao situacao,
        LocalDateTime createAt,
        LocalDateTime lastUpdate
){
    public AtividadeExibirDadosDto(AtividadeModel dados){
        this(dados.getId(), new ImovelExibirDadosDto(dados.getImovel()), new ClienteExibirDadosDto(dados.getCliente()),
                dados.getAtivo(), dados.getVencimento(), dados.getSituacao(), dados.getCreateAt(), dados.getLastUpdate());
    }
}
