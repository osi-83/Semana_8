package br.com.projetos_sustentaveis.sustentavel.repository;

import br.com.projetos_sustentaveis.sustentavel.entity.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {

    List<Organizacao> findByNameContainingIgnoreCaseAndContatoContainingIgnoreCase(String name, String contato);

    List<Organizacao> findByNameContainingIgnoreCase(String name);

    List<Organizacao> findByContatoContainingIgnoreCase(String contato);
}
