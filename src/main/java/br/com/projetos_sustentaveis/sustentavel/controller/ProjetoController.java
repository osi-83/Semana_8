package br.com.projetos_sustentaveis.sustentavel.controller;

import br.com.projetos_sustentaveis.sustentavel.dto.ProjetoDTO;
import br.com.projetos_sustentaveis.sustentavel.entity.Projeto;
import br.com.projetos_sustentaveis.sustentavel.service.ProjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ProjetoDTO dto) {
        Optional<Projeto> projetoSalvo = service.salvar(dto);

        if (projetoSalvo.isPresent()) {
            return ResponseEntity.ok(projetoSalvo.get());
        } else {
            return ResponseEntity.badRequest().body("Organização não encontrada");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody ProjetoDTO dto) {
        Optional<Projeto> projetoAtualizado = service.atualizar(id, dto);

        if (projetoAtualizado.isPresent()) {
            return ResponseEntity.ok(projetoAtualizado.get());
        } else {
            return ResponseEntity.badRequest().body("Projeto ou Organização não encontrada");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Projeto> projeto = service.buscarPorId(id);

        if (projeto.isPresent()) {
            return ResponseEntity.ok(projeto.get());
        } else {
            return ResponseEntity.status(404).body("Projeto não encontrado");
        }
    }
}