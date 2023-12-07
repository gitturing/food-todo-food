package edu.example.food.service;

import edu.example.food.dto.DTOProducto;
import edu.example.food.models.Producto;
import edu.example.food.repositories.ProductoRepository;
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
public class ProductoService {
    private ProductoRepository productoRepository;

    public Mono<DTOProducto> findById(Integer id) {
        return productoRepository.findById(id)
                .map(producto -> new DTOProducto(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getPrecio(),
                        producto.getDescripcion(),
                        producto.getId_restaurante()
                ))
                .onErrorResume(throwable -> {
                    log.error("Error al consultar un producto con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Producto con id= " + id + " no encontrado").getMostSpecificCause()));
    }

    public Flux<DTOProducto> findAll() {
        return productoRepository.findAll()
                .map(producto -> new DTOProducto(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getPrecio(),
                        producto.getDescripcion(),
                        producto.getId_restaurante()
                ))
                .onErrorResume(throwable -> {
                    log.error("Error al consultar todos los productos", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningun producto encontrado").getMostSpecificCause()));
    }
}
