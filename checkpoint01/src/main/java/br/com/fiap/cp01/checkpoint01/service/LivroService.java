package br.com.fiap.cp01.checkpoint01.service;

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
         return livroRepository.findById(id).orElseThrow(() -> RecursoNaoEncontradoException("Livro não encontrado com Id: ", id));

     }

     public Livro salvar(Livro livro) {
         return livroRepository.save(livro);
     }




}
