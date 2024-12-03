package com.studendesk.application.service.interfaces;

import com.studendesk.domain.model.dto.CursoDto;
import com.studendesk.domain.model.request.CursoRequest;

import java.util.List;

public interface CursoIService {
    void crearCurso(CursoRequest request);

    void matricularEstudiante(Integer idCurso, Integer idEstudiante);

    List<CursoDto> obtenerCursosPorProfesor(Integer idProfesor);

    CursoDto obtenerCursoPorId(Integer idCurso);
}
