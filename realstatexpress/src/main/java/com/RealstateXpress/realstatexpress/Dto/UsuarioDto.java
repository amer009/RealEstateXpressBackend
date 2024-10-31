package com.RealstateXpress.realstatexpress.Dto;

import lombok.Data;

import java.sql.Date;

@Data
public class UsuarioDto {

    private String nombre;
    private String email;
    private Long telefono;
    private String clave;
    private Long rol;
}
