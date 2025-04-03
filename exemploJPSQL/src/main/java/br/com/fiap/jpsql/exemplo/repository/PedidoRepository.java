package br.com.fiap.jpsql.exemplo.repository;

import br.com.fiap.jpsql.exemplo.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    //Derived Query Method: buscar pedidos por cliente
    List<Pedido> findByCliente(String cliente);

    //JPQL Query : busca pedidos acima de um valor
    @Query("SELECT p FROM Pedido p WHERE p.total > :valor")
    List<Pedido> buscarPedidosPorValor(@Param("valor") BigDecimal valor);


    //Native Query: buscar pedidos por data.
    @Query(value = "SELECT * FROM pedido WHERE data_pedido BETWEEN: inicio AND : fim", nativeQuery = true)
    List<Pedido> buscarPedidosPorPeriodo (@Param("inicio")LocalDate inicio, @Param("fim") LocalDate fim);

    //Paginacao: retorna pedidos paginados
    Page<Pedido> findAll(Pageable pageable);



}
