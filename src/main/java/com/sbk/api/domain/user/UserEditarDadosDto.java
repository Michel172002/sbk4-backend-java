package com.sbk.api.domain.user;

public record UserEditarDadosDto (
        String nome,
        String senha,
        Cargo cargo
){

}
