package edu.example.food.controller;

import edu.example.food.dto.DTOPedido;
import edu.example.food.service.PedidosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidosController {

    private PedidosService pedidosService;

    @GetMapping("/v1/getPedido/{id}")
    public Mono<DTOPedido> consultarPedidosId(@PathVariable Integer id) {
        return pedidosService.findById(id);
    }

    @GetMapping("/v1/getPedidos")
    public Flux<DTOPedido> consultarTodosLosPedidos() {
        return pedidosService.findAll();
    }

}
