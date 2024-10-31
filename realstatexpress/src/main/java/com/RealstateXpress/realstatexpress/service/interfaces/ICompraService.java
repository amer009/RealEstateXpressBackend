package com.RealstateXpress.realstatexpress.service.interfaces;

import com.RealstateXpress.realstatexpress.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraService extends JpaRepository<Compra,Long> {
}
