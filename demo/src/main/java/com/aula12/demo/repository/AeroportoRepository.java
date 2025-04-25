package com.aula12.demo.repository;

import com.aula12.demo.model.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
}
