package com.studendesk.domain.repositoryPort;

import com.studendesk.domain.model.dto.config.GeneroDto;

import java.util.List;

public interface GeneroRepositoryPort {

    List<GeneroDto> obtenerGeneros();
    GeneroDto obtenerGeneroPorId(Integer id);
}
