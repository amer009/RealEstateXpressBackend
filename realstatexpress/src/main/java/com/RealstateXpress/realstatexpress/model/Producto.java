package com.RealstateXpress.realstatexpress.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private String nombre_producto;
    private String ubicacion;
    private Double precio;
    private Double area;
    private Double tamanio;
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_estado",referencedColumnName = "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_compra", nullable = true)
    private Compra compra;

}
