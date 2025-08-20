package br.com.projetos_sustentaveis.sustentavel.dto;

import jakarta.validation.constraints.NotBlank;

public record OrganizacaoDTO(
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O contato é obrigatório.")
        String contato
) {}
