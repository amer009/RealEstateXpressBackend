package com.RealstateXpress.realstatexpress.service.implement;

import com.RealstateXpress.realstatexpress.Dto.LoginDto;
import com.RealstateXpress.realstatexpress.Dto.ResponseDto;
import com.RealstateXpress.realstatexpress.Dto.UsuarioDto;
import com.RealstateXpress.realstatexpress.model.Rol;
import com.RealstateXpress.realstatexpress.model.Usuario;
import com.RealstateXpress.realstatexpress.repository.IRolRepository;
import com.RealstateXpress.realstatexpress.repository.IUsuarioRepository;
import com.RealstateXpress.realstatexpress.service.interfaces.IUsuarioService;
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
    public ResponseDto save(UsuarioDto input) {

        Usuario NewUser = Usuario.builder().build();
        Optional<Rol> rol =rolRepository.findById(input.getId_rol());
        if (rol.isPresent()) {

            Optional<Usuario> valid = userRepository.findByEmail(input.getEmail());

            if (valid.isPresent()) {
                return ResponseDto.builder().codigoRespuesta("06").mensaje("Error usuario ya existe").build();
            }

            NewUser = userRepository.save(Usuario.builder()
                    .fecha(new Date())
                    .clave(input.getClave())
                    .telefono(input.getTelefono())
                    .nombre(input.getNombre())
                            .rol(rol.get())
                    .email(input.getEmail()).build());
            return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(UsuarioDto.builder()
                    .nombre(NewUser.getNombre())
                    .telefono(NewUser.getTelefono())
                    .email(NewUser.getEmail())
                    .id_rol(NewUser.getRol().getId_rol())
                    .build()).build();


        }
        return ResponseDto.builder().codigoRespuesta("05").mensaje("Error").build();
    }

    @Override
    public ResponseDto getAll() {

        List<UsuarioDto> list = new  ArrayList<>();
        List<Usuario> tblUsuarios = userRepository.findAll();
        for (int i = 0; i < tblUsuarios.size(); i++) {
            list.add(UsuarioDto.builder()
                            .nombre(tblUsuarios.get(i).getNombre())
                            .telefono(tblUsuarios.get(i).getTelefono())
                            .email(tblUsuarios.get(i).getEmail())
                            .id_rol(tblUsuarios.get(i).getRol().getId_rol())
                    .build());
        }

        return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(list).build();

    }

    @Override
    public ResponseDto login(UsuarioDto input) {

       Optional<Usuario> User= userRepository.findByEmailAndClave(input.getEmail(),input.getClave());
        if (User.isPresent()) {
            return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(LoginDto.builder()
                    .nombre(User.get().getNombre())
                    .email(User.get().getEmail())
                    .rol(User.get().getRol().getTipoRol())
                    .build()).build();

        } else {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("Usuario o clave invalida").data(false).build();
        }

    }

    @Override
    public ResponseDto find(Long id) {
        Optional<Usuario> User = userRepository.findById(id);
        if (User.isPresent()) {
            return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(UsuarioDto.builder()
                    .nombre(User.get().getNombre())
                    .telefono(User.get().getTelefono())
                    .email(User.get().getEmail())
                    .id_rol(User.get().getRol().getId_rol())
                    .build()).build();
        } else {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("No existe").data(false).build();
        }
    }

    @Override
    public ResponseDto update(Long id, UsuarioDto input) {
        Optional<Usuario> User = userRepository.findById(id);

        if (User.isPresent()) {
            User.get().setNombre(input.getNombre());
            User.get().setTelefono(input.getTelefono());
            User.get().setTelefono(input.getTelefono());
            User.get().setEmail(input.getEmail());

            userRepository.save(User.get());

            return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(UsuarioDto.builder()
                    .nombre(User.get().getNombre())
                    .telefono(User.get().getTelefono())
                    .email(User.get().getEmail())
                    .id_rol(User.get().getRol().getId_rol())
                    .build()).build();

        } else {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("No existe").data(false).build();

        }
    }

    @Override
    public ResponseDto delete(Long id) {
        Optional<Usuario> User = userRepository.findById(id);

        if (User.isPresent()) {
            userRepository.deleteById(id);
            return ResponseDto.builder().codigoRespuesta("00").mensaje("Exito").data(true).build();

        } else {
            return ResponseDto.builder().codigoRespuesta("05").mensaje("Usuario o clave invalida").data(false).build();

        }
    }
}
