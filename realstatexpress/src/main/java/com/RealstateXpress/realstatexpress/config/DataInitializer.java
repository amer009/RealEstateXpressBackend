package com.RealstateXpress.realstatexpress.config;


import com.RealstateXpress.realstatexpress.model.Estado;
import com.RealstateXpress.realstatexpress.model.Rol;
import com.RealstateXpress.realstatexpress.repository.IEstadoRepository;
import com.RealstateXpress.realstatexpress.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private IEstadoRepository estadoRepository;
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
        };
    }
}
