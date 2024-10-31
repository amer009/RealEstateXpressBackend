package com.RealstateXpress.realstatexpress.service.implement;

import com.RealstateXpress.realstatexpress.model.Rol;
import com.RealstateXpress.realstatexpress.repository.IRolRepository;
import com.RealstateXpress.realstatexpress.service.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolService implements IRolService {

    @Autowired
    IRolRepository rolRepository;

    @Override
    public Rol save(String rol) {
        return null;
    }
}
