package com.fiap.jpaRelacionamentos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.jpaRelacionamentos.model.Livro;
import com.fiap.jpaRelacionamentos.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	private final LivroRepository lr;
	
	public LivroController( LivroRepository lr ) {
		this.lr = lr;
	}
	
	//criar um novo livro --> POST
	@PostMapping
	public Livro criarLivro( @RequestBody Livro livro ) {
		return lr.save(livro);
	}
	
	//buscar todos os livros --> GET
	@GetMapping
	public List<Livro> listarLivros(){
		return lr.findAll();
	}
	
	//buscar livro por id --> GET
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
		return lr.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	//atualizar um livro --> PUT
	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro la) {
	    return lr.findById(id).map(livro -> {
	        livro.setTitulo(la.getTitulo());
	        return ResponseEntity.ok(lr.save(livro));
	    }).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	//deletar o livro --> DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarLivro(@PathVariable Long id){
		if(lr.existsById(id)) {
			lr.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build(); 
	}

}
