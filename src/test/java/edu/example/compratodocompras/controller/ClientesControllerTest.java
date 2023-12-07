package edu.example.compratodocompras.controller;

import edu.example.food.controller.ClienteController;
import edu.example.food.dto.DTOCliente;
import edu.example.food.service.ClienteService;
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
public class ClientesControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveClientesExitoso() {
        var cliente = new DTOCliente(1, "Juan Diaz", "1100892202", "Juan@example.com", "Cr9-32-39", "3165768904", "2020-10-10");
        when(clienteService.crearCliente(ArgumentMatchers.any())).thenReturn(Mono.just(cliente));
        StepVerifier.create(clienteController.saveCliente(cliente))
                .expectNextMatches(dtoCliente -> dtoCliente.equals(cliente))
                .expectComplete()
                .verify();
    }

    @Test
    void testConsultarClientesExitoso() {
        var cliente = new DTOCliente(1, "Juan Diaz", "1100892202", "Juan@example.com", "Cr9-32-39", "3165768904", "2020-10-10");
        when(clienteService.findAll()).thenReturn(Flux.just(cliente));
        StepVerifier.create(clienteController.consultarTodosLosClientes())
                .expectNextMatches(dtoCliente -> dtoCliente.equals(cliente))
                .expectComplete()
                .verify();
    }

    @Test
    void testConsultarClientesPorIdExitoso() {
        var cliente = new DTOCliente(1, "Juan Diaz", "1100892202", "Juan@example.com", "Cr9-32-39", "3165768904", "2020-10-10");
        when(clienteService.findById(ArgumentMatchers.anyInt())).thenReturn(Mono.just(cliente));
        StepVerifier.create(clienteController.consultarClienteId(1))
                .expectNextMatches(dtoCliente -> dtoCliente.id().equals(1))
                .expectComplete()
                .verify();
    }

    @Test
    void testEliminarClientesPorIdExitoso() {
        var cliente = new DTOCliente(1, "Juan Diaz", "1100892202", "Juan@example.com", "Cr9-32-39", "3165768904", "2020-10-10");
        when(clienteService.deleteById(ArgumentMatchers.anyInt())).thenReturn(Mono.just(cliente));
        StepVerifier.create(clienteController.eliminarClientesPorId(1))
                .expectNextMatches(dtoCliente -> dtoCliente.id().equals(1))
                .expectComplete()
                .verify();
    }
}
