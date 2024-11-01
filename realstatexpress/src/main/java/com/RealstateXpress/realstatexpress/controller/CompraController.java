package com.RealstateXpress.realstatexpress.controller;

import com.RealstateXpress.realstatexpress.Dto.ProductoDto;
import com.RealstateXpress.realstatexpress.Dto.RequestComprar;
import com.RealstateXpress.realstatexpress.Dto.ResponseDto;
import com.RealstateXpress.realstatexpress.model.Producto;
import com.RealstateXpress.realstatexpress.service.interfaces.ICompraService;
import com.RealstateXpress.realstatexpress.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/comprar")
public class CompraController {

    @Autowired
    ICompraService services;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> comprarProducto(@RequestBody RequestComprar req){
        return ResponseEntity.ok(this.services.comprar(req));
    }
}
