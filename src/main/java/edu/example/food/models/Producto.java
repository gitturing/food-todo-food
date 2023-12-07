package edu.example.food.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("productos")
public class Producto {
    @Id
    private Integer id;
    private String nombre;
    private Float precio;
    private String descripcion;
    private Integer id_restaurante;
}
