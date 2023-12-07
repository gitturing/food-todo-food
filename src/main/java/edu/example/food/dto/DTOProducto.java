package edu.example.food.dto;

public record DTOProducto(Integer id,
                          String nombre,
                          Float precio,
                          String descripcion,
                          Integer idRestaurante)
{}
