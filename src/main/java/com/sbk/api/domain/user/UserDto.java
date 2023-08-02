package com.sbk.api.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotBlank
        String nome,

        @NotBlank
        String senha,

        @NotNull
        Cargo cargo
) {
}
