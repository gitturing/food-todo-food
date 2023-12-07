package edu.example.food.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table("clientes")
public class Cliente implements AccionesClientes{
    @Id
    private Integer id;
    private String nombre;
    private String documento;
    private String email;
    private String direccion;
    private String telefono;
    private LocalDate fecha_fegistro;

    @Override
    public String obtenerDatosContactoCliente() {
        return "email: " + email + " telefono: " + telefono + " Direccion: " + direccion;
    }
}
