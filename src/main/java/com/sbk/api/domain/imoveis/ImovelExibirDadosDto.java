package com.sbk.api.domain.imoveis;

import com.sbk.api.domain.proprietario.ProprietarioExibirDadosDto;

public record ImovelExibirDadosDto(
        Long id,
        String tipo,
        Double preco,
        Boolean alugando,
        Boolean financia,
        String area,
        String rua,
        String bairro,
        String cidade,
        String numero,
        String complemento,
        String estado,
        String cep,
        String comodos,
        String descricao,
        ProprietarioExibirDadosDto proprietario
) {
    public ImovelExibirDadosDto(ImovelModel dados){
        this(dados.getId(), dados.getTipo(), dados.getPreco(), dados.getAlugando(),
                dados.getFinancia(), dados.getArea(), dados.getRua(), dados.getBairro(), dados.getCidade(),
                dados.getNumero(), dados.getComplemento(), dados.getEstado(), dados.getCep(), dados.getComodos(), dados.getDescricao(),
                new ProprietarioExibirDadosDto(dados.getProprietario()));
    }
}
