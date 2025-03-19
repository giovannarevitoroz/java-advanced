package br.com.fiap.cp01.checkpoint01.service;


import br.com.fiap.cp01.checkpoint01.exception.LivroNaoEncontradoException;
import br.com.fiap.cp01.checkpoint01.model.Livro;
import br.com.fiap.cp01.checkpoint01.repository.LivroRepository;
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
        return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException("Livro nao encontrado com Id: " + id));
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {
        Livro livro = buscarPorId(id);
        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setIsbn(livro.getIsbn());
        livro.setDisponivel(livroAtualizado.isDisponivel());

        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        Livro livro = buscarPorId(id);
        livroRepository.delete(livro);
    }

    public Page<Livro> buscarPorTitulo(String titulo, Pageable pageable) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo, pageable);
    }


}
