package br.com.projetos_sustentaveis.sustentavel.repository;

import br.com.projetos_sustentaveis.sustentavel.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    List<Projeto> findByRegiaoContainingIgnoreCase(String regiao);

    List<Projeto> findByOrganizacao_NameContainingIgnoreCase(String name);

    List<Projeto> findByRegiaoContainingIgnoreCaseAndOrganizacao_NameContainingIgnoreCase(String regiao, String name);
}
