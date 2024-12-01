package com.studendesk.infrastructure.persistence.adapter;

import com.studendesk.domain.model.dto.CursoDto;
import com.studendesk.domain.repositoryPort.CursoRepositoryPort;
import com.studendesk.infrastructure.persistence.mapper.CursoMapper;
import com.studendesk.infrastructure.persistence.repository.CursoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CursoRepositoryAdapter implements CursoRepositoryPort {

    private final CursoJpaRepository cursoJpaRepository;
    private final CursoMapper cursoMapper;

    @Override
    public void crearCurso(CursoDto cursoDto) {
        cursoJpaRepository.save(cursoMapper.toEntity(cursoDto));
    }
}
