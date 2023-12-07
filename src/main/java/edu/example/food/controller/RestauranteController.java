package edu.example.food.controller;

import edu.example.food.dto.DTORestaurante;
import edu.example.food.service.RestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/restaurante")
@AllArgsConstructor
public class RestauranteController {

    private RestauranteService restauranteService;

    @GetMapping("/v1/getRestaurante/{id}")
    public Mono<DTORestaurante> consultarRestauranteId(@PathVariable Integer id) {
        return restauranteService.findById(id);
    }

    @GetMapping("/v1/getRestaurantes")
    public Flux<DTORestaurante> consultarTodosLosRestaurantes() {
        return restauranteService.findAll();
    }

}
