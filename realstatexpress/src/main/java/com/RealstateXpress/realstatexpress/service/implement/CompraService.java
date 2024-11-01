package com.RealstateXpress.realstatexpress.service.implement;

import com.RealstateXpress.realstatexpress.Dto.RequestComprar;
import com.RealstateXpress.realstatexpress.Dto.ResponseDto;
import com.RealstateXpress.realstatexpress.model.Compra;
import com.RealstateXpress.realstatexpress.model.Estado;
import com.RealstateXpress.realstatexpress.model.Producto;
import com.RealstateXpress.realstatexpress.model.Usuario;
import com.RealstateXpress.realstatexpress.repository.ICompraRepository;
import com.RealstateXpress.realstatexpress.repository.IEstadoRepository;
import com.RealstateXpress.realstatexpress.repository.IProductoRepository;
import com.RealstateXpress.realstatexpress.repository.IUsuarioRepository;
import com.RealstateXpress.realstatexpress.service.interfaces.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.Optional;


@Component
public class CompraService implements ICompraService {

    @Autowired
    ICompraRepository compraRepository;

    @Autowired
    IProductoRepository productRepository;

    @Autowired
    IEstadoRepository estadoRepository;

    @Autowired
    IUsuarioRepository userReposiory;


    @Override
    public ResponseDto comprar(RequestComprar input) {

        Optional<Producto> p = productRepository.findById(input.getId_producto());
        Optional<Usuario> u = userReposiory.findById(input.getId_usuario());
        Estado vendido = estadoRepository.findByTipoEstado("Vendido");

        if (p.isEmpty()) {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("Error producto no existe").build();
        }

        if (p.get().getEstado().getTipoEstado().equals("Vendido")) {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("Error producto ya vendido").build();
        }

        if (u.isEmpty()) {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("Error usuario no existe").build();
        }

        if (u.get().getRol().getTipoRol().equals("Administrador")) {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("Error usuario no valido para vender").build();
        }


        Compra c = compraRepository.save(Compra.builder().fecha_compra(new Date()).usuario(u.get()).build());
        p.get().setEstado(vendido);
        p.get().setCompra(c);
        Producto updateProducto = p.get();
        productRepository.save(updateProducto);
        return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito compra creada con id "+c.getId_compra()).build();

    }
}
