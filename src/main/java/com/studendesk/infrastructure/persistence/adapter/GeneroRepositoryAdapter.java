package com.studendesk.infrastructure.persistence.adapter;

import com.studendesk.domain.exceptions.HttpGenericException;
import com.studendesk.domain.model.dto.config.GeneroDto;
import com.studendesk.domain.repositoryPort.GeneroRepositoryPort;
import com.studendesk.infrastructure.persistence.mapper.GeneroMapper;
import com.studendesk.infrastructure.persistence.repository.GeneroJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class GeneroRepositoryAdapter implements GeneroRepositoryPort {

    private final GeneroJpaRepository generoRepository;
    private final GeneroMapper generoMapper;

    @Override
    public List<GeneroDto> obtenerGeneros() {
        return generoRepository.findAll().stream()
                .map(generoMapper::toDto)
                .toList();
    }

    @Override
    public GeneroDto obtenerGeneroPorId(Integer id) {
        return generoMapper.toDto(generoRepository.findById(id)
                .orElseThrow(()-> new HttpGenericException(HttpStatus.BAD_REQUEST,"No se encontró el género")));
    }
}
