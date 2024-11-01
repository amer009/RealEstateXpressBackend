package com.RealstateXpress.realstatexpress.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {

    private String codigoRespuesta;
    private String mensaje;
    private Object data;

}
