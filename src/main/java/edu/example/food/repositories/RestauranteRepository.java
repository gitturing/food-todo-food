package edu.example.food.repositories;

import edu.example.food.models.Restaurante;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends ReactiveCrudRepository<Restaurante, Integer> {
}
