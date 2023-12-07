package edu.example.food.controller;

import edu.example.food.dto.DTOProducto;
import edu.example.food.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {

    private ProductoService productoService;

    @GetMapping("/v1/getProducto/{id}")
    public Mono<DTOProducto> consultarProductoId(@PathVariable Integer id){
        return productoService.findById(id);
    }

    @GetMapping("/v1/getProductos")
    public Flux<DTOProducto> consultarTodosLosProductos(){
        return productoService.findAll();
    }

}
