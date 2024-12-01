package com.studendesk.domain.repositoryPort;

import com.studendesk.domain.model.dto.config.GeneroDto;

public interface GeneroRepositoryPort {

    GeneroDto obtenerGeneroPorId(Integer id);
}
