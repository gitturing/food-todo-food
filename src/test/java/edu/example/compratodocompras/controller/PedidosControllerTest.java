package edu.example.compratodocompras.controller;

import edu.example.food.controller.PedidosController;
import edu.example.food.dto.DTOPedido;
import edu.example.food.service.PedidosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PedidosControllerTest {

    @Mock
    private PedidosService pedidosService;

    @InjectMocks
    private PedidosController pedidosController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarPedidosExitoso() {
        var pedidos = new DTOPedido(1, 1, 1, "2023-01-01", 50.00, "Despachado");
        when(pedidosService.findAll()).thenReturn(Flux.just(pedidos));
        StepVerifier.create(pedidosController.consultarTodosLosPedidos())
                .expectNextMatches(pedido -> pedido.equals(pedidos))
                .expectComplete()
                .verify();
    }

    @Test
    void testConsultarPedidosPorIdExitoso() {
        var pedidos = new DTOPedido(1, 1, 1, "2023-01-01", 50.00, "Despachado");
        when(pedidosService.findById(ArgumentMatchers.anyInt())).thenReturn(Mono.just(pedidos));
        StepVerifier.create(pedidosController.consultarPedidosId(1))
                .expectNextMatches(pedido -> pedido.id().equals(1))
                .expectComplete()
                .verify();
    }
}
