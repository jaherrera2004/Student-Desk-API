package com.studendesk.application.service.impl;

import com.studendesk.application.service.interfaces.ConfigIService;
import com.studendesk.domain.consts.DatosGenerales;
import com.studendesk.domain.model.dto.config.GeneroDto;
import com.studendesk.domain.model.dto.config.RolDto;
import com.studendesk.domain.model.response.ConfigResponse;
import com.studendesk.domain.repositoryPort.GeneroRepositoryPort;
import com.studendesk.domain.repositoryPort.RolRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ConfigServiceImpl implements ConfigIService {

    private final RolRepositoryPort rolRepositoryPort;
    private final GeneroRepositoryPort generoRepositoryPort;

    @Override
    public ConfigResponse obtenerConfigData() {

        List<RolDto> roles = new ArrayList<>(rolRepositoryPort.obtenerRoles());
        roles.removeIf(rolDto -> rolDto.getId() == DatosGenerales.ROL_ADMIN);

        List<GeneroDto> generos = new ArrayList<>(generoRepositoryPort.obtenerGeneros());

        return new ConfigResponse(roles, generos);
    }
}
