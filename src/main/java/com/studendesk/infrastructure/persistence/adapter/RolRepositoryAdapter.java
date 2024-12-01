package com.studendesk.infrastructure.persistence.adapter;

import com.studendesk.domain.exceptions.HttpGenericException;
import com.studendesk.domain.model.dto.config.RolDto;
import com.studendesk.domain.repositoryPort.RolRepositoryPort;
import com.studendesk.infrastructure.persistence.mapper.RolMapper;
import com.studendesk.infrastructure.persistence.repository.RolJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class RolRepositoryAdapter implements RolRepositoryPort {

    private final RolJpaRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public RolDto obtenerRolPorId(Integer id) {
        return rolMapper.toDto(rolRepository.findById(id)
                .orElseThrow(()->new HttpGenericException(HttpStatus.BAD_REQUEST,"No se encontro el rol")));
    }

    @Override
    public List<RolDto> obtenerRoles() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toDto)
                .toList();
    }
}
