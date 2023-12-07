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
@Table("restaurantes")
public class Restaurante {
    @Id
    private Integer id;
    private String nombre;
    private String tipoCocina;
    private String ubicacion;
}
