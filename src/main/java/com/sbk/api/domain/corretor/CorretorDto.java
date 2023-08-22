package com.sbk.api.domain.corretor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CorretorDto(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        String creci
) {
}
