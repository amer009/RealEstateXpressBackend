package com.RealstateXpress.realstatexpress.service.interfaces;

import com.RealstateXpress.realstatexpress.Dto.ProductoDto;
import com.RealstateXpress.realstatexpress.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductoService {

    Producto save(ProductoDto input);
    List<Producto> getAll();
    Producto find(Long id);
    Producto update( Long id,ProductoDto input);
    Boolean delete(Long id);
}
