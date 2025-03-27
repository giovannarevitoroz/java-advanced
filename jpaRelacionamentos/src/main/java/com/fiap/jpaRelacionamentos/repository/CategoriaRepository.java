package com.fiap.jpaRelacionamentos.repository;

import com.fiap.jpaRelacionamentos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
