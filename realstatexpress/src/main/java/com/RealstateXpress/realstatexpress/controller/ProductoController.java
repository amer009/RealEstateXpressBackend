package com.RealstateXpress.realstatexpress.controller;

import com.RealstateXpress.realstatexpress.Dto.ProductoDto;
import com.RealstateXpress.realstatexpress.Dto.ResponseDto;
import com.RealstateXpress.realstatexpress.Dto.UsuarioDto;
import com.RealstateXpress.realstatexpress.model.Producto;
import com.RealstateXpress.realstatexpress.model.Usuario;
import com.RealstateXpress.realstatexpress.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    IProductoService services;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> saveProducto(@RequestBody ProductoDto req){
        return ResponseEntity.ok(this.services.save(req));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> getAll(){
        return ResponseEntity.ok(this.services.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
        return ResponseEntity.ok(this.services.update(id, productoDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.services.delete(id));
    }
}
