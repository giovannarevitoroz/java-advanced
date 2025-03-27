package com.fiap.jpaRelacionamentos.controller;

import com.fiap.jpaRelacionamentos.model.Categoria;
import com.fiap.jpaRelacionamentos.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository ct;

    public CategoriaController(CategoriaRepository ct) {
        this.ct = ct;
    }

    @PostMapping
    public Categoria criarCategoria (@RequestBody Categoria categoria) {
        return ct.save(categoria);
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return ct.findAll();
    }

    @GetMapping
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id) {
        return ct.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivroPorId (@PathVariable Long id) {
        if (ct.existsById(id)) {
            ct.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
