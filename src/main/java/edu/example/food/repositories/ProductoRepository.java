package edu.example.food.repositories;

import edu.example.food.models.Producto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductoRepository extends ReactiveCrudRepository<Producto, Integer> {
}
