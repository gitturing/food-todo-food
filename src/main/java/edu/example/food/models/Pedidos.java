package edu.example.food.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "pedidos")
public class Pedidos implements AccionesPedidos{

    @Id
    private Integer id;
    private Integer id_cliente;
    private Integer id_restaurante;
    private LocalDate fecha;
    private Double total;
    private String estado;

    @Override
    public Double obtenerDescuentoPedido() {
        var descuento = 0.10;
        return total * descuento;
    }
}
