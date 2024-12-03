package com.studendesk.domain.repositoryPort;

import com.studendesk.domain.model.dto.CursoDto;


public interface CursoRepositoryPort {

    void crearCurso(CursoDto cursoDto);

    void matricularEstudiante(Integer idCurso, Integer idEstudiante);
}
