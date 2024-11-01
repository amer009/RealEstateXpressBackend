package com.RealstateXpress.realstatexpress.service.interfaces;

import com.RealstateXpress.realstatexpress.Dto.RequestComprar;
import com.RealstateXpress.realstatexpress.Dto.ResponseDto;

public interface ICompraService{

    ResponseDto comprar(RequestComprar input);
}
