package com.aula12.demo.repository;

import com.aula12.demo.model.Voo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface VooRepository extends JpaRepository<Voo, Long> {

    //Query Method
    List<Voo> findByCompanhiaisContainingIgnoreCase(String companhia);

    //Query JPQL
    @Query("SELECT v FROM Voo v WHERE v.origem.cidade = :cidade")
    List<Voo> buscarPorOrigemCidade(@Param("cidade")String cidade);

    //Query native
    @Query(value = "SELECT * FROM voo WHERE companhia = :companhia", nativeQuery = true)
    List<Voo> buscarPorCompanhiaNativa(@Param("companhia") String companhia);

    //Paginacao
    Page<Voo> findAll(Pageable pageable);


}
