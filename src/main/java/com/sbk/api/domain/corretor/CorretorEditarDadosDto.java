package com.sbk.api.domain.corretor;

public record CorretorEditarDadosDto (
        Long id,
        String nome,
        String telefone,
        String creci,
        Boolean ativo
){
}
