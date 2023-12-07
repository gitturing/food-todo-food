package edu.example.food.service;

import edu.example.food.dto.DTOCliente;
import edu.example.food.models.Cliente;
import edu.example.food.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Slf4j
@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Mono<DTOCliente> crearCliente(DTOCliente dtoClienteEntrada) {

        var client = Cliente.builder()
                .nombre(dtoClienteEntrada.nombre())
                .documento(dtoClienteEntrada.documento())
                .email(dtoClienteEntrada.email())
                .direccion(dtoClienteEntrada.direccion())
                .telefono(dtoClienteEntrada.telefono())
                .fecha_fegistro(LocalDate.parse(dtoClienteEntrada.fecha_fegistro()))
                .build();

        return clienteRepository.save(client)
                .map(cliente -> new DTOCliente(
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getDocumento(),
                        cliente.getEmail(),
                        cliente.getTelefono(),
                        cliente.getDireccion(),
                        cliente.getFecha_fegistro().toString()
                ));
    }

    public Mono<DTOCliente> findById(Integer id) {
        return clienteRepository.findById(id)
                .map(cliente -> new DTOCliente(
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getDocumento(),
                        cliente.getEmail(),
                        cliente.getTelefono(),
                        cliente.getDireccion(),
                        cliente.getFecha_fegistro().toString()
                ))
                .onErrorResume(throwable -> {
                    log.error("Error al consultar el cliente con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "cliente con id= " + id + " no encontrado").getMostSpecificCause()));
    }

    public Flux<DTOCliente> findAll() {
        return clienteRepository.findAll()
                .map(cliente -> new DTOCliente(
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getDocumento(),
                        cliente.getEmail(),
                        cliente.getDireccion(),
                        cliente.getTelefono(),
                        cliente.getFecha_fegistro().toString()
                ))
                .onErrorResume(throwable -> {
                    log.error("Error al consultar todos los clientes", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningun cliente encontrado").getMostSpecificCause()));
    }

    public Mono<Void> deleteAll() {
        return clienteRepository.deleteAll()
                .onErrorResume(throwable -> {
                    log.error("Error al borrar todos los clientes", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "cliente no borrados").getMostSpecificCause()));
    }

    public Mono<DTOCliente> deleteById(Integer id) {
        return clienteRepository.findById(id)
                .flatMap(producto -> clienteRepository.deleteById(producto.getId()).thenReturn(producto))
                .map(cliente -> new DTOCliente(
                        cliente.getId(), 
                        cliente.getNombre(),
                        cliente.getDocumento(),
                        cliente.getEmail(),
                        cliente.getTelefono(),
                        cliente.getDireccion(),
                        cliente.getFecha_fegistro().toString()
                ))
                .onErrorResume(throwable -> {
                    log.error("Error al borrar el cliente con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "cliente con id= " + id + " no borrado").getMostSpecificCause()));
    }
}
