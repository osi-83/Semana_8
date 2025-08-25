package br.com.projetos_sustentaveis.sustentavel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projeto")
@Getter @Setter
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = " Uso de energia fotovoltaica")
    private String name;

    @NotBlank(message = "O uso de energias renováveis, deve ser uma " +
            "questão a ser discutida de forma mais consciente pela sociedade;")
    private String descricao;

    @NotBlank(message = "Norte, estado de Sc.")
    private String regiao;

    @PositiveOrZero(message = "A estimativa de CO2 não pode ser negativa, quando" +
            "há uma redução no uso de combustiveis fósseis.")
    private Double estimativaReducaoCO2;

    @ManyToOne
    @JoinColumn(name = "organizacao_id", nullable = false)
    private Organizacao organizacao;
}
