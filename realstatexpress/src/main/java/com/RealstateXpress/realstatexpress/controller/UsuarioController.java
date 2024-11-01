package com.RealstateXpress.realstatexpress.controller;

import com.RealstateXpress.realstatexpress.Dto.ResponseDto;
import com.RealstateXpress.realstatexpress.Dto.UsuarioDto;
import com.RealstateXpress.realstatexpress.model.Usuario;
import com.RealstateXpress.realstatexpress.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService userServices;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> saveUsuario(@RequestBody UsuarioDto req){
        return ResponseEntity.ok(this.userServices.save(req));
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> login(@RequestBody UsuarioDto req){
        return ResponseEntity.ok(this.userServices.login(req));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> getAll(){
        return ResponseEntity.ok(this.userServices.getAll());
    }

}
