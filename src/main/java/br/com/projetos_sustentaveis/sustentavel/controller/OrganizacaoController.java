package br.com.projetos_sustentaveis.sustentavel.controller;

import br.com.projetos_sustentaveis.sustentavel.dto.OrganizacaoDTO;
import br.com.projetos_sustentaveis.sustentavel.entity.Organizacao;
import br.com.projetos_sustentaveis.sustentavel.service.OrganizacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizations")
public class OrganizacaoController {

    private final OrganizacaoService service;

    public OrganizacaoController(OrganizacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Organizacao>> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String contato
    ) {
        List<Organizacao> organizacoes = service.listar(nome, contato);
        return ResponseEntity.ok(organizacoes);
    }@PostMapping
    public ResponseEntity<Organizacao> salvar(@RequestBody Organizacao organizacao) {
        return ResponseEntity.ok(service.salvar(organizacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizacao> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}