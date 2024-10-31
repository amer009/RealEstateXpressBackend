package com.RealstateXpress.realstatexpress.repository;

import com.RealstateXpress.realstatexpress.model.Estado;
import com.RealstateXpress.realstatexpress.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmailAndClave(String email, String clave);
}
