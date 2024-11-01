package com.RealstateXpress.realstatexpress.service.interfaces;

import com.RealstateXpress.realstatexpress.Dto.ProductoDto;
import com.RealstateXpress.realstatexpress.Dto.ResponseDto;
import com.RealstateXpress.realstatexpress.Dto.UsuarioDto;
import com.RealstateXpress.realstatexpress.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsuarioService {

    ResponseDto save(UsuarioDto input);

    ResponseDto getAll();

    ResponseDto login(UsuarioDto input);

    ResponseDto find(Long id);
    ResponseDto update(Long id, UsuarioDto input);
    ResponseDto delete(Long id);
}
