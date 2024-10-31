package com.RealstateXpress.realstatexpress.repository;

import com.RealstateXpress.realstatexpress.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado,Long> {
    Estado findByTipoEstado(String tipoEstado);
}
