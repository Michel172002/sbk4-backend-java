package com.sbk.api.domain.atividade;

public record AtividadeEditarDadosDto (
        Long id,
        Long idImovel,
        Long idCliente,
        Boolean ativo,
        Integer vencimento,
        Situacao situacao
){
}
