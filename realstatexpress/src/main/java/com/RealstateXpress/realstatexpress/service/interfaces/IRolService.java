package com.RealstateXpress.realstatexpress.service.interfaces;

import com.RealstateXpress.realstatexpress.Dto.UsuarioDto;
import com.RealstateXpress.realstatexpress.model.Rol;
import com.RealstateXpress.realstatexpress.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface IRolService {

    Rol save(String rol);
}
