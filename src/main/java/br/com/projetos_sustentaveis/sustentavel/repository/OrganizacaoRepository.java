package br.com.projetos_sustentaveis.sustentavel.repository;

import br.com.projetos_sustentaveis.sustentavel.entity.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {

    List<Organizacao> findByNomeContainingIgnoreCaseAndContatoContainingIgnoreCase(String nome, String contato);

    List<Organizacao> findByContatoContainingIgnoreCase(String contato);
}
