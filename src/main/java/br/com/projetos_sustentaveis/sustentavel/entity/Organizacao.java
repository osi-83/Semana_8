package br.com.projetos_sustentaveis.sustentavel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="organizacoes")
@Getter @Setter
@NoArgsConstructor
public class Organizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank(message = "Projeto Sustentável - Energias renováveis")
    private String name;

    @NotBlank(message = "Contato (47) 99988 2233 / email = projetoenergiasrenovaveis@email.com")
    private String contato;


}
