package com.RealstateXpress.realstatexpress.service.implement;

import com.RealstateXpress.realstatexpress.Dto.ProductoDto;
import com.RealstateXpress.realstatexpress.model.*;
import com.RealstateXpress.realstatexpress.repository.ICompraRepository;
import com.RealstateXpress.realstatexpress.repository.IEstadoRepository;
import com.RealstateXpress.realstatexpress.repository.IProductoRepository;
import com.RealstateXpress.realstatexpress.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoService implements IProductoService {

    @Autowired
    IProductoRepository productRepository;

    @Autowired
    IEstadoRepository estadoRepository;

    @Autowired
    ICompraRepository compraRepository;

    @Override
    public Producto save(ProductoDto input) {
        Producto NewProduct = Producto.builder().build();
        Optional<Estado> estado =estadoRepository.findById(input.getId_estado());
        if (estado.isPresent()) {
            NewProduct = productRepository.save(Producto.builder()
                    .nombre_producto(input.getNombre_producto())
                    .ubicacion(input.getUbicacion())
                    .precio(input.getPrecio())
                    .area(input.getArea())
                    .tamanio(input.getTamanio())
                    .estado(estado.get())
                    .imagen(input.getImagen())
                    .build());

        }
        return NewProduct;
    }

    @Override
    public List<Producto> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Producto find(Long id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public Producto update( Long id,ProductoDto input) {
        Optional<Producto> product = productRepository.findById(id);

        if (product.isPresent()) {
            product.get().setArea(input.getArea());
            product.get().setNombre_producto(input.getNombre_producto());
            product.get().setUbicacion(input.getUbicacion());
            product.get().setPrecio(input.getPrecio());
            product.get().setTamanio(input.getTamanio());
            product.get().setImagen(input.getImagen());
            if (input.getId_compra() != null) {
                Optional<Compra> compra = compraRepository.findById(input.getId_compra());
                compra.ifPresent(value -> product.get().setCompra(value));
            }


        } else {
            return null;
        }


        return productRepository.save(product.get());
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Producto> product = productRepository.findById(id);

        if (product.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
