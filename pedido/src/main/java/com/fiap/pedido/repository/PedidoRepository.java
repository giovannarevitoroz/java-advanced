package com.fiap.pedido.repository;

import com.fiap.pedido.model.PedidoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//ponte para interagir com o banco de dados
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

    Page<PedidoModel> findAll(Pageable pageable);
}
