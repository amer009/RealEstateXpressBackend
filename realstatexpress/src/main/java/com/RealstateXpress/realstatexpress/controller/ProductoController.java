package com.RealstateXpress.realstatexpress.controller;

import com.RealstateXpress.realstatexpress.Dto.ProductoDto;
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
    public Producto saveProducto(@RequestBody ProductoDto req){
        return this.services.save(req);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> getAll(){
        return ResponseEntity.ok(this.services.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
        Producto productoActualizado = this.services.update(id, productoDto);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.services.delete(id);
        return ResponseEntity.ok("Producto eliminado exitosamente");
    }
}
