package com.fiap.exemploLombok.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.exemploLombok.model.Pedido;
import com.fiap.exemploLombok.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController // definindo que essa classe é um controller Rest
@RequestMapping("/pedidos") // define a URL base para o endpoint
@RequiredArgsConstructor // gera um construtor para injeção de dependencias
public class PedidoController {
	
	private final PedidoService pedidoService = new PedidoService();
	
	@GetMapping
	public List<Pedido> listarTodos() {
		return pedidoService.listarTodos();
	}
	
	@PostMapping
	public Pedido criarPedido(@RequestBody Pedido pedido) {
		return pedidoService.salvar(pedido);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoService.buscarPedidoPorId(id);
		return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirPedido(@PathVariable Long id) {
		boolean removido = pedidoService.excluir(id);
		
		if(removido) {
			return ResponseEntity.ok("/nPedido excluído com sucesso!!!");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
