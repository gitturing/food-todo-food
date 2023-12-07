package edu.example.compratodocompras.controller;

import edu.example.food.controller.RestauranteController;
import edu.example.food.dto.DTORestaurante;
import edu.example.food.service.RestauranteService;
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
public class RestauranteControllerTest {

    @Mock
    private RestauranteService restauranteService;

    @InjectMocks
    private RestauranteController restauranteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarRestaurantesExitoso() {
        var restaurante = new DTORestaurante(1, "Poly", "Comida Internacional", "Cr9-32-39");
        when(restauranteService.findAll()).thenReturn(Flux.just(restaurante));
        StepVerifier.create(restauranteController.consultarTodosLosRestaurantes())
                .expectNextMatches(dtoRestaurante -> dtoRestaurante.equals(restaurante))
                .expectComplete()
                .verify();
    }

    @Test
    void testConsultarRestaurantesPorIdExitoso() {
        var restaurante = new DTORestaurante(1, "Poly", "Comida Internacional", "Cr9-32-39");
        when(restauranteService.findById(ArgumentMatchers.anyInt())).thenReturn(Mono.just(restaurante));
        StepVerifier.create(restauranteController.consultarRestauranteId(1))
                .expectNextMatches(dtoRestaurante -> dtoRestaurante.id().equals(1))
                .expectComplete()
                .verify();
    }
}
