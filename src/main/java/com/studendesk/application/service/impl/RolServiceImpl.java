package com.studendesk.application.service.impl;

import com.studendesk.application.service.interfaces.RolIService;
import com.studendesk.domain.consts.DatosGenerales;
import com.studendesk.domain.model.dto.config.RolDto;
import com.studendesk.domain.repositoryPort.RolRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RolServiceImpl implements RolIService {

    private final RolRepositoryPort rolRepositoryPort;

    @Override
    public List<RolDto> obtenerRoles() {

        List<RolDto> roles = new ArrayList<>(rolRepositoryPort.obtenerRoles());
        roles.removeIf(rolDto -> rolDto.getId() == DatosGenerales.ROL_ADMIN);

        return roles;
    }
}
