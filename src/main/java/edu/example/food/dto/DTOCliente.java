package edu.example.food.dto;

public record DTOCliente(Integer id,
                         String nombre,
                         String documento,
                         String email,
                         String direccion,
                         String telefono,
                         String fecha_fegistro) {
}
