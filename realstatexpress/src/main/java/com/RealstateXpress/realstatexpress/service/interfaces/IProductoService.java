package com.RealstateXpress.realstatexpress.service.interfaces;

import com.RealstateXpress.realstatexpress.Dto.ProductoDto;
import com.RealstateXpress.realstatexpress.Dto.ResponseDto;
import com.RealstateXpress.realstatexpress.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductoService {

    ResponseDto save(ProductoDto input);
    ResponseDto getAll();
    ResponseDto find(Long id);
    ResponseDto update( Long id,ProductoDto input);
    ResponseDto delete(Long id);
}
