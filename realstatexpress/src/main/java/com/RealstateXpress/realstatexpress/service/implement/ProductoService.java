package com.RealstateXpress.realstatexpress.service.implement;

import com.RealstateXpress.realstatexpress.Dto.ProductoDto;
import com.RealstateXpress.realstatexpress.Dto.ResponseDto;
import com.RealstateXpress.realstatexpress.Dto.UsuarioDto;
import com.RealstateXpress.realstatexpress.model.*;
import com.RealstateXpress.realstatexpress.repository.ICompraRepository;
import com.RealstateXpress.realstatexpress.repository.IEstadoRepository;
import com.RealstateXpress.realstatexpress.repository.IProductoRepository;
import com.RealstateXpress.realstatexpress.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoService implements IProductoService {

    @Autowired
    IProductoRepository productRepository;

    @Autowired
    IEstadoRepository estadoRepository;

    @Override
    public ResponseDto save(ProductoDto input) {
        Producto NewProduct = Producto.builder().build();
        Estado estado =estadoRepository.findByTipoEstado("En venta");

            NewProduct = productRepository.save(Producto.builder()
                    .nombre_producto(input.getNombre_producto())
                    .ubicacion(input.getUbicacion())
                    .precio(input.getPrecio())
                    .area(input.getArea())
                    .tamanio(input.getTamanio())
                    .estado(estado)
                    .imagen(input.getImagen())
                    .build());

        return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(ProductoDto.builder()
                        .nombre_producto(NewProduct.getNombre_producto())
                        .ubicacion(NewProduct.getUbicacion())
                        .precio(NewProduct.getPrecio())
                        .area(NewProduct.getArea())
                        .tamanio(NewProduct.getTamanio())
                        .id_estado(NewProduct.getEstado().getId_estado())
                        .imagen(NewProduct.getImagen())
                .build()).build();

    }

    @Override
    public ResponseDto getAll() {

        List<ProductoDto> list = new ArrayList<>();
        List<Producto> tblProductos = productRepository.findAll();
        for (int i = 0; i < tblProductos.size(); i++) {
            list.add(ProductoDto.builder()
                            .id_producto(tblProductos.get(i).getId_producto())
                    .nombre_producto(tblProductos.get(i).getNombre_producto())
                    .ubicacion(tblProductos.get(i).getUbicacion())
                    .precio(tblProductos.get(i).getPrecio())
                    .area(tblProductos.get(i).getArea())
                    .tamanio(tblProductos.get(i).getTamanio())
                    .id_estado(tblProductos.get(i).getEstado().getId_estado())
                    .imagen(tblProductos.get(i).getImagen())
                    .id_compra(tblProductos.get(i).getCompra() != null ? tblProductos.get(i).getCompra().getId_compra() : null)
                    .id_estado(tblProductos.get(i).getEstado().getId_estado())
                    .build());
        }
        return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(list).build();

    }

    @Override
    public ResponseDto find(Long id) {
        Optional<Producto> producto = productRepository.findById(id);
        if (producto.isPresent()) {
            return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(ProductoDto.builder()
                    .nombre_producto(producto.get().getNombre_producto())
                    .ubicacion(producto.get().getUbicacion())
                    .precio(producto.get().getPrecio())
                    .area(producto.get().getArea())
                    .tamanio(producto.get().getTamanio())
                    .id_estado(producto.get().getEstado().getId_estado())
                    .imagen(producto.get().getImagen())
                    .build()).build();
        } else {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("No existe").data(false).build();
        }
    }

    @Override
    public ResponseDto update( Long id,ProductoDto input) {
        Optional<Producto> product = productRepository.findById(id);

        if (product.isPresent()) {
            product.get().setArea(input.getArea());
            product.get().setNombre_producto(input.getNombre_producto());
            product.get().setUbicacion(input.getUbicacion());
            product.get().setPrecio(input.getPrecio());
            product.get().setTamanio(input.getTamanio());
            product.get().setImagen(input.getImagen());

            productRepository.save(product.get());

            return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(ProductoDto.builder()
                    .nombre_producto(product.get().getNombre_producto())
                    .ubicacion(product.get().getUbicacion())
                    .precio(product.get().getPrecio())
                    .area(product.get().getArea())
                    .tamanio(product.get().getTamanio())
                    .id_estado(product.get().getEstado().getId_estado())
                    .imagen(product.get().getImagen())
                    .build()).build();

        } else {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("No existe").data(false).build();

        }

    }

    @Override
    public ResponseDto delete(Long id) {
        Optional<Producto> product = productRepository.findById(id);

        if (product.isPresent()) {
            productRepository.deleteById(id);
            return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(true).build();

        } else {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("Usuario o clave invalida").data(false).build();

        }
    }
}
