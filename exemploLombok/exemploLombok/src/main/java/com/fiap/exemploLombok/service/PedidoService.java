package com.fiap.exemploLombok.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiap.exemploLombok.model.Pedido;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // cria automaticamente um construtor para os atributos do tipo final
public class PedidoService {
	
	private final List<Pedido> pedidos = new ArrayList<>();
	
	private Long contadorId = 1L; //simula um id automaticamente
	
	//metodo para listar todos os pedidos
	public List<Pedido> listarTodos(){
		return pedidos;
	}
	
	//metodo para adicionar um pedido
	public Pedido salvar(Pedido pedido) {
		pedido.setId(contadorId++);
		pedidos.add(pedido);
		return pedido;
	}
	
	//metodo buscar pedidoPorId
	public Optional<Pedido> buscarPedidoPorId(Long id) {
		return pedidos.stream().filter(p -> p.getId().equals(id)).findFirst(); // filtra os elementos para o id igual passado por argumento
	}
	
	//metodo para excluir um pedido
	public boolean excluir(Long id) {
		return pedidos.removeIf(pedido -> pedido.getId().equals(id));
	}

}
