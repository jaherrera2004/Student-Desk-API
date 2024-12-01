package com.studendesk.domain.repositoryPort;

import com.studendesk.domain.model.dto.config.RolDto;

import java.util.List;

public interface RolRepositoryPort {
    RolDto obtenerRolPorId(Integer id);
    List<RolDto> obtenerRoles();
}
