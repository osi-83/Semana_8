package br.com.projetos_sustentaveis.sustentavel.repository;

import br.com.projetos_sustentaveis.sustentavel.entity.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContainingIgnoreCase extends JpaRepository<Organizacao, Long>  {

    List<Organizacao> findByNameContainingIgnoreCase(String name);

    List<Organizacao> findByContatoContainingIgnoreCase(String contato);

    List<Organizacao> findByNomeContainingIgnoreCaseAndContatoContainingIgnoreCase
            (String nome, String contato );
}
