package edu.example.food.controller;

import edu.example.food.dto.DTOCliente;
import edu.example.food.service.ClienteService;
import edu.example.food.service.ClienteServiceKafka;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;
    private ClienteServiceKafka  clienteServiceKafka;

    @GetMapping("/v1/cliente/{id}")
    public Mono<DTOCliente> consultarClienteId(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping("/v1/save")
    public Mono<DTOCliente> saveCliente(@RequestBody DTOCliente dtoClienteEntrada) {
        return clienteService.crearCliente(dtoClienteEntrada);
    }

    @GetMapping("/v1/getClientes")
    public Flux<DTOCliente> consultarTodosLosClientes() {
        return clienteService.findAll();
    }

    @DeleteMapping("/v1/delete")
    public Mono<Void> eliminarClientes() {
        return clienteService.deleteAll();
    }

    @DeleteMapping("/v1/delete/{id}")
    public Mono<DTOCliente> eliminarClientesPorId(@PathVariable Integer id) {
        return clienteService.deleteById(id);
    }

    @GetMapping("/topico-kafka/{topico}")
    public Mono<String> obtenerClientesDesdeKafkaContrpller(@PathVariable String topico){
        return clienteServiceKafka.obtenerClientesDesdeKafka(topico)
                .flatMap(cliente -> clienteService.crearCliente(cliente))
                .then()
                .map(unused -> "Clientes alamacenado ok desde kafka");
    }
}
