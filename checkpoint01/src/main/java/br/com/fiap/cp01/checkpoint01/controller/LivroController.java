package br.com.fiap.cp01.checkpoint01.controller;


import br.com.fiap.cp01.checkpoint01.model.Livro;
import br.com.fiap.cp01.checkpoint01.service.LivroService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<Page<Livro>> listarLivros(Pageable pageable){
        return ResponseEntity.ok(livroService.listarLivros(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));

    }

    @PostMapping
    public ResponseEntity<Livro> criar(@Valid @RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.salvar(livro));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<Livro>> buscarPorTitulo(@RequestParam String titulo, Pageable pageable) {
        return ResponseEntity.ok(livroService.buscarPorTitulo(titulo, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.atualizar(id, livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
