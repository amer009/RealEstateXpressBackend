package com.RealstateXpress.realstatexpress.service.implement;

import com.RealstateXpress.realstatexpress.Dto.UsuarioDto;
import com.RealstateXpress.realstatexpress.model.Rol;
import com.RealstateXpress.realstatexpress.model.Usuario;
import com.RealstateXpress.realstatexpress.repository.IRolRepository;
import com.RealstateXpress.realstatexpress.repository.IUsuarioRepository;
import com.RealstateXpress.realstatexpress.service.interfaces.IUsuarioService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioService implements IUsuarioService {

    @Autowired
    IUsuarioRepository userRepository;

    @Autowired
    IRolRepository rolRepository;

    @Override
    public Usuario save(UsuarioDto input) {

        Usuario NewUser = Usuario.builder().build();
        Optional<Rol> rol =rolRepository.findById(input.getRol());
        if (rol.isPresent()) {
            NewUser = userRepository.save(Usuario.builder()
                    .fecha(new Date())
                    .clave(input.getClave())
                    .telefono(input.getTelefono())
                    .nombre(input.getNombre())
                            .rol(rol.get())
                    .email(input.getEmail()).build());

        }
        return NewUser;
    }

    @Override
    public List<Usuario> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean login(UsuarioDto input) {

       Optional<Usuario> User= userRepository.findByEmailAndClave(input.getEmail(),input.getClave());
        return User.isPresent();

    }
}
