package com.fiap.exercicio.repository;

import com.fiap.exercicio.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

    Page<Funcionario> findAll(Pageable pageable);

    Page<Funcionario> findByTituloContainingIgnoreCase(String nome, Pageable pageable);
}
