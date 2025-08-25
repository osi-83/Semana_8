package br.com.projetos_sustentaveis.sustentavel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record ProjetoDTO(
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotBlank(message = "A região é obrigatória")
        String regiao,

        @PositiveOrZero(message = "A estimativa não pode ser negativa")
        Double estimativaReducaoCO2,

        long organizacaoId
) {}
