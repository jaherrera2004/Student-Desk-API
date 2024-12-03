package com.studendesk.infrastructure.persistence.adapter;

import com.studendesk.domain.exceptions.HttpGenericException;
import com.studendesk.domain.model.dto.CursoDto;
import com.studendesk.domain.model.response.CursoResponse;
import com.studendesk.domain.repositoryPort.CursoRepositoryPort;
import com.studendesk.infrastructure.persistence.entity.CursoEntity;
import com.studendesk.infrastructure.persistence.mapper.CursoMapper;
import com.studendesk.infrastructure.persistence.repository.CursoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CursoRepositoryAdapter implements CursoRepositoryPort {

    private final CursoJpaRepository cursoJpaRepository;
    private final CursoMapper cursoMapper;

    @Override
    public void crearCurso(CursoDto cursoDto) {
        cursoJpaRepository.save(cursoMapper.toEntity(cursoDto));
    }

    @Override
    public void matricularEstudiante(Integer idCurso, Integer idEstudiante) {
        cursoJpaRepository.matricularEstudiante(idCurso, idEstudiante);
    }

    @Override
    public List<CursoDto> obtenerCursosPorProfesor(Integer idProfesor) {
        List<CursoEntity> cursoEntities = cursoJpaRepository.findCursoEntitiesByProfesor_Id(idProfesor);

        return cursoJpaRepository.findCursoEntitiesByProfesor_Id(idProfesor)
                .stream()
                .map(cursoMapper::toDto)
                .toList();
    }

    @Override
    public CursoDto obtenerCursoPorId(Integer idCurso) {
        return cursoJpaRepository.findById(idCurso)
                .map(cursoMapper::toDto)
                .orElseThrow(() -> new HttpGenericException(HttpStatus.BAD_REQUEST, "Curso no encontrado"));
    }
}
