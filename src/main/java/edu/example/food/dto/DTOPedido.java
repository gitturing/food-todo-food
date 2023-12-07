



package edu.example.food.dto;

public record DTOPedido(Integer id,
                        Integer id_cliente,
                        Integer id_restaurante,
                        String fecha,
                        Double total,
                        String estado) {
}
