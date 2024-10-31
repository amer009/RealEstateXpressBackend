package com.RealstateXpress.realstatexpress.service.interfaces;

import com.RealstateXpress.realstatexpress.Dto.UsuarioDto;
import com.RealstateXpress.realstatexpress.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsuarioService {

    Usuario save(UsuarioDto input);

    List<Usuario> getAll();

    Boolean login(UsuarioDto input);
}
