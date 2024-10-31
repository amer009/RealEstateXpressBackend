package com.RealstateXpress.realstatexpress.repository;

import com.RealstateXpress.realstatexpress.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra,Long> {
}
