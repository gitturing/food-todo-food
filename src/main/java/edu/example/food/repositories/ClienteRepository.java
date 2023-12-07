package edu.example.food.repositories;

import edu.example.food.models.Cliente;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends R2dbcRepository<Cliente, Integer> {
}
