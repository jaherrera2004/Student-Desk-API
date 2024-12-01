package com.studendesk.domain.repositoryPort;

import com.studendesk.domain.model.dto.config.RolDto;

public interface RolRepositoryPort {
    RolDto obtenerRolPorId(Integer id);
}
