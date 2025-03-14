package com.fiap.pedido.service;

import com.fiap.pedido.exception.RecursoNaoEncontradoException;
import com.fiap.pedido.model.PedidoModel;
import com.fiap.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Page<PedidoModel> listarPedidos(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    public PedidoModel buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado com ID: " + id));
    }

    public PedidoModel salvar(PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }

    public PedidoModel atualizar(Long id, PedidoModel pedidoAtualizado) {

        PedidoModel pedido = buscarPorId(id);
        pedido.setNomeCliente(pedidoAtualizado.getNomeCliente());
        pedido.setDescricao(pedidoAtualizado.getDescricao());
        pedido.setEntregue(pedidoAtualizado.isEntregue());

        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        PedidoModel pedido = buscarPorId(id);
        pedidoRepository.delete(pedido);
    }

}
