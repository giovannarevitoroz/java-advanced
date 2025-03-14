package com.fiap.pedido.controller;


import com.fiap.pedido.model.PedidoModel;
import com.fiap.pedido.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<Page<PedidoModel>> listarPedidos(Pageable pageable){
        return ResponseEntity.ok(pedidoService.listarPedidos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criar(@Valid @RequestBody PedidoModel pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvar(pedido));
    }
}
