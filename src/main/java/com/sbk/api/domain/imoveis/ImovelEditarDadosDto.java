package com.sbk.api.domain.imoveis;

public record ImovelEditarDadosDto(
        Long idProp,
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
        String descricao

) {
}
