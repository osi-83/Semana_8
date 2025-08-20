package br.com.projetos_sustentaveis.sustentavel.service;

import br.com.projetos_sustentaveis.sustentavel.dto.ProjetoDTO;
import br.com.projetos_sustentaveis.sustentavel.entity.Organizacao;
import br.com.projetos_sustentaveis.sustentavel.entity.Projeto;
import br.com.projetos_sustentaveis.sustentavel.repository.OrganizacaoRepository;
import br.com.projetos_sustentaveis.sustentavel.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;
    private final OrganizacaoRepository organizacaoRepository;

    public ProjetoService(ProjetoRepository repository, OrganizacaoRepository organizacaoRepository) {
        this.repository = repository;
        this.organizacaoRepository = organizacaoRepository;
    }

    public Optional<Projeto> salvar(ProjetoDTO dto) {
        return organizacaoRepository.findById(dto.organizacaoId())
                .map(org -> {
                    Projeto projeto = new Projeto();
                    projeto.setNome(dto.nome());
                    projeto.setDescricao(dto.descricao());
                    projeto.setRegiao(dto.regiao());
                    projeto.setEstimativaReducaoCO2(dto.estimativaReducaoCO2());
                    projeto.setOrganizacao(org);
                    return repository.save(projeto);
                });
    }

    public List<Projeto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Projeto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Projeto> atualizar(Long id, ProjetoDTO dto) {
        return repository.findById(id).flatMap(p ->
                organizacaoRepository.findById(dto.organizacaoId()).map(org -> {
                    p.setNome(dto.nome());
                    p.setDescricao(dto.descricao());
                    p.setRegiao(dto.regiao());
                    p.setEstimativaReducaoCO2(dto.estimativaReducaoCO2());
                    p.setOrganizacao(org);
                    return repository.save(p);
                })
        );
    }

    public boolean deletar(Long id) {
        return repository.findById(id).map(p -> {
            repository.delete(p);
            return true;
        }).orElse(false);
    }
}