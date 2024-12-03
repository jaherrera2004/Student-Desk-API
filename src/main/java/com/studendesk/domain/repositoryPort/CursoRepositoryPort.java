package com.studendesk.domain.repositoryPort;

import com.studendesk.domain.model.dto.CursoDto;

import java.util.List;


public interface CursoRepositoryPort {

    void crearCurso(CursoDto cursoDto);

    void matricularEstudiante(Integer idCurso, Integer idEstudiante);

    List<CursoDto> obtenerCursosPorProfesor(Integer idProfesor);

    CursoDto obtenerCursoPorId(Integer idCurso);
}
