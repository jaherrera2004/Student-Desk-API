package com.studendesk.application.service.interfaces;

import com.studendesk.domain.model.request.CursoRequest;

public interface CursoIService {
    void crearCurso(CursoRequest request);
    void matricularEstudiante(Integer idCurso, Integer idEstudiante);
}
