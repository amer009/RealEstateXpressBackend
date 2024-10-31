package com.RealstateXpress.realstatexpress.repository;

import com.RealstateXpress.realstatexpress.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Long> {
    Rol findByTipoRol(String tipoRol);
}
