package br.com.fiap.jpsql.exemplo.controller;

import br.com.fiap.jpsql.exemplo.model.Pedido;
import br.com.fiap.jpsql.exemplo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pedidos")

public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;


    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @GetMapping
    public Page<Pedido> listarPedidos(@RequestParam(defaultValue = "0") int pagina,
                                      @RequestParam(defaultValue = "5") int tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho);//cria um objeto para definir a paginacao
        return pedidoRepository.findAll(pageable);
    }

    @GetMapping("/cliente/{nome}")
    public List<Pedido> buscarPorCliente(@PathVariable String nome) {
        return pedidoRepository.findByCLiente(nome);

    }

    @GetMapping("/valor")
    public List<Pedido> buscaPorValor(@RequestParam BigDecimal valor) {
        return pedidoRepository.buscarPedidosPorValor(valor);
    }

    @GetMapping("periodo")
    public List<Pedido> buscarPorPeriodo(@RequestParam String inicio, @RequestParam String fim) {
        return pedidoRepository.buscarPedidosPorPeriodo(LocalDate.parse(inicio),LocalDate.parse(fim));
    }

}
