package edu.example.food.service;

import edu.example.food.dto.DTOPedido;
import edu.example.food.repositories.PedidosRepository;
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
public class PedidosService {
    private PedidosRepository ventasRepository;

    public Mono<DTOPedido> findById(Integer id) {
        return ventasRepository.findById(id)
                .map(pedidos -> new DTOPedido(
                        pedidos.getId(),
                        pedidos.getId_cliente(),
                        pedidos.getId_restaurante(),
                        pedidos.getFecha().toString(),
                        pedidos.getTotal(),
                        pedidos.getEstado()

                ))
                .onErrorResume(throwable -> {
                    log.error("Error al consultar el pedido con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pedido con id= " + id + " no encontrado").getMostSpecificCause()));
    }

    public Flux<DTOPedido> findAll() {
        return ventasRepository.findAll()
                .map(pedidos -> new DTOPedido(
                        pedidos.getId(),
                        pedidos.getId_cliente(),
                        pedidos.getId_restaurante(),
                        pedidos.getFecha().toString(),
                        pedidos.getTotal(),
                        pedidos.getEstado()

                ))
                .onErrorResume(throwable -> {
                    log.error("Error al consultar todas los pedidos", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningun pedido encontrado").getMostSpecificCause()));
    }
}
