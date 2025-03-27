package com.fiap.jpaRelacionamentos.service;

import com.fiap.jpaRelacionamentos.exception.CategoriaNaoEcontradaException;
import com.fiap.jpaRelacionamentos.exception.LivroNaoEncontradoException;
import com.fiap.jpaRelacionamentos.model.Livro;
import com.fiap.jpaRelacionamentos.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Page<Livro> listarLivros(Pageable pageable) {
        return livroRepository.findAll(pageable);

    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException("Livro nao encontrado com id: " + id));
    }

    public Livro salvar(Livro livro) {
        if (livro.getCategoria() != null) {
            return livroRepository.save(livro);
        } else {
            throw new CategoriaNaoEcontradaException("Categoria nao encontrada");
        }
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {

        Livro livro = buscarPorId(id);

        if (livroAtualizado.getId() != null) {
            livro.setAutor(livroAtualizado.getAutor());
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setCategoria(livroAtualizado.getCategoria());
            return livroRepository.save(livroAtualizado);

        }else{
            throw new LivroNaoEncontradoException("Livro nao encontrado, tente novamente");
        }

    }

    public void deletar(Long id) {
        Livro livro = buscarPorId(id);
        livroRepository.delete(livro);
    }

}