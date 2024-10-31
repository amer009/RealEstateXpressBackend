package com.RealstateXpress.realstatexpress.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoDto{
private String nombre_producto;
private String ubicacion;
private Double precio;
private Double area;
private Double tamanio;
private String imagen;
private Long id_estado;
private Long id_compra;
}
