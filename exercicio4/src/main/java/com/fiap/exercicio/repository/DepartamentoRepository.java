package com.fiap.exercicio.repository;

import com.fiap.exercicio.model.Departamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {

    Page<Departamento> findAll(Pageable pageable);

    Page<Departamento> findByTituloContainingIgnoreCase(String nome, Pageable pageable);
}
