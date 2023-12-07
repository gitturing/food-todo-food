package edu.example.food.service;

import edu.example.food.dto.DTORestaurante;
import edu.example.food.repositories.RestauranteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class RestauranteService {

    private RestauranteRepository detalleVentaRepository;

    public Mono<DTORestaurante> findById(Integer id) {
        return detalleVentaRepository.findById(id)
                .map(restaurante -> new DTORestaurante(
                        restaurante.getId(),
                        restaurante.getNombre(),
                        restaurante.getTipoCocina(),
                        restaurante.getUbicacion()
                ))
                .onErrorResume(throwable -> {
                    log.error("Error al consultar el restaurante con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "restaurante con id= " + id + " no encontrado").getMostSpecificCause()));
    }

    public Flux<DTORestaurante> findAll() {
        return detalleVentaRepository.findAll()
                .map(restaurante -> new DTORestaurante(
                        restaurante.getId(),
                        restaurante.getNombre(),
                        restaurante.getTipoCocina(),
                        restaurante.getUbicacion()
                ))
                .onErrorResume(throwable -> {
                    log.error("Error al consultar todos los detalles de de la venta", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningun detalle de venta encontrado").getMostSpecificCause()));
    }
}
