package edu.example.food.controller;

import edu.example.food.dto.DTOProducto;
import edu.example.food.service.ProductoService;
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
public class ProductoControllerTest {

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarProductosExitoso(){
        var product = new  DTOProducto(1,"Cheleta de cerdo", 10.0F, "Descripción del Producto 1", 1);
        when(productoService.findAll()).thenReturn(Flux.just(product));
        StepVerifier.create(productoController.consultarTodosLosProductos())
                .expectNextMatches(dtoProducto -> dtoProducto.equals(product))
                .expectComplete()
                .verify();
    }

    @Test
    void testConsultarProductoPorIdExitoso(){
        var product = new  DTOProducto(1,"Cheleta de cerdo", 10.0F, "Descripción del Producto 1", 1);
        when(productoService.findById(ArgumentMatchers.anyInt())).thenReturn(Mono.just(product));
        StepVerifier.create(productoController.consultarProductoId(1))
                .expectNextMatches(dtoProducto -> dtoProducto.id().equals(1))
                .expectComplete()
                .verify();
    }
}
