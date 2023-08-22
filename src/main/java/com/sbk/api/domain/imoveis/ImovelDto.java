package com.sbk.api.domain.imoveis;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ImovelDto (
        @NotNull
        Long idProp,
        @NotBlank
        String tipo,
        @NotNull
        Double preco,
        @NotNull
        Boolean alugando,
        @NotNull
        Boolean financia,
        @NotBlank
        String area,
        @NotBlank
        String rua,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String numero,
        @NotBlank
        String complemento,
        @NotBlank
        String estado,
        @NotBlank
        String cep,
        @NotBlank
        String comodos,
        @NotBlank
        String descricao
) {
}
