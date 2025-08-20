package br.com.projetos_sustentaveis.sustentavel.service;

import br.com.projetos_sustentaveis.sustentavel.dto.OrganizacaoDTO;
import br.com.projetos_sustentaveis.sustentavel.entity.Organizacao;
import br.com.projetos_sustentaveis.sustentavel.repository.OrganizacaoRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import jakarta.persistence.Id;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizacaoService {

    private final OrganizacaoRepository repository;

    public OrganizacaoService(OrganizacaoRepository repository) {
        this.repository = repository;
    }

    public List<Organizacao> listar(String nome, String contato) {
        if (nome != null && contato != null) {
            return repository.findByNameContainingIgnoreCaseAndContatoContainingIgnoreCase(nome, contato);
        } else if (nome != null) {
            return repository.findByNameContainingIgnoreCase(nome);
        } else if (contato != null) {
            return repository.findByContatoContainingIgnoreCase(contato);
        } else {
            return repository.findAll();
        }
    }

    public Organizacao salvar(Organizacao organizacao) {
        return repository.save(organizacao);
    }

    public Optional<Organizacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
