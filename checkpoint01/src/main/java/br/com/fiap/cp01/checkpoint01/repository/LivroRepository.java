package br.com.fiap.cp01.checkpoint01.repository;

import br.com.fiap.cp01.checkpoint01.model.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface LivroRepository  extends JpaRepository<Livro, Long> {

    Page<Livro> findAll(Pageable pageable);

}
