package com.RealstateXpress.realstatexpress.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto
{
    private String nombre;
    private String email;
    private String rol;
}
