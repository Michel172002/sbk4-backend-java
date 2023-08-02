package com.sbk.api.domain.user;

import java.time.LocalDateTime;

public record UserExibirDadosDto (
        Long id,
        String nome,
        String senha,
        Cargo cargo,
        LocalDateTime createAt,
        LocalDateTime lastUpdate
){
    public UserExibirDadosDto(UserModel dados){
        this(dados.getId(), dados.getNome(), dados.getSenha(), dados.getCargo(), dados.getCreateAt(), dados.getLastUpdate());
    }
}
