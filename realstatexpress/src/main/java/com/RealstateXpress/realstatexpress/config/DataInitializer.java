package com.RealstateXpress.realstatexpress.config;


import com.RealstateXpress.realstatexpress.model.Estado;
import com.RealstateXpress.realstatexpress.model.Rol;
import com.RealstateXpress.realstatexpress.model.Usuario;
import com.RealstateXpress.realstatexpress.repository.ICompraRepository;
import com.RealstateXpress.realstatexpress.repository.IEstadoRepository;
import com.RealstateXpress.realstatexpress.repository.IRolRepository;
import com.RealstateXpress.realstatexpress.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Configuration
public class DataInitializer {

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private IEstadoRepository estadoRepository;

    @Autowired
    IUsuarioRepository userReposiory;
    @Bean
    public ApplicationRunner initializeData() {
        return args -> {

            // Inicializar roles
            if (rolRepository.findByTipoRol("Administrador") == null) {
                rolRepository.save(Rol.builder().tipoRol("Administrador").build());
            }
            if (rolRepository.findByTipoRol("Usuario") == null) {
                rolRepository.save(Rol.builder().tipoRol("Usuario").build());
            }

            // Inicializar estados
            if (estadoRepository.findByTipoEstado("Vendido") == null) {
                estadoRepository.save(Estado.builder().tipoEstado("Vendido").build());
            }
            if (estadoRepository.findByTipoEstado("En venta") == null) {
                estadoRepository.save(Estado.builder().tipoEstado("En venta").build());
            }

            if (userReposiory.findByEmail("realestatexpress2024@gmail.com").isEmpty()) {

                Rol r =rolRepository.findByTipoRol("Administrador");
                userReposiory.save(Usuario.builder()
                        .fecha(new Date())
                        .clave(encriptarSHA256("admin1234"))
                        .telefono(3123697894L)
                        .nombre("Administrador")
                        .rol(r)
                        .email("realestatexpress2024@gmail.com").build());
            }
        };
    }

    public static String encriptarSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
