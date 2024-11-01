package com.RealstateXpress.realstatexpress.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {

    private String nombre;
    private String email;
    private Long telefono;
    private String clave;
    private Long id_rol;
}
