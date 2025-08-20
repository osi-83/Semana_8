package br.com.projetos_sustentaveis.sustentavel.repository;

import br.com.projetos_sustentaveis.sustentavel.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
