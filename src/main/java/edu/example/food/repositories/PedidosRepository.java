package edu.example.food.repositories;

import edu.example.food.models.Pedidos;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends R2dbcRepository<Pedidos, Integer> {
}
