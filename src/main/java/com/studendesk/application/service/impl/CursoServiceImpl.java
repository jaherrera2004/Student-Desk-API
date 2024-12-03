package com.studendesk.application.service.impl;

import com.studendesk.application.service.interfaces.CursoIService;
import com.studendesk.domain.exceptions.HttpGenericException;
import com.studendesk.domain.model.dto.CursoDto;
import com.studendesk.domain.model.dto.UsuarioDto;
import com.studendesk.domain.model.request.CursoRequest;
import com.studendesk.domain.repositoryPort.CursoRepositoryPort;
import com.studendesk.domain.repositoryPort.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CursoServiceImpl implements CursoIService {

    private final CursoRepositoryPort cursoRepositoryPort;
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    @Override
    public void crearCurso(CursoRequest request) {

        UsuarioDto profesor = usuarioRepositoryPort.obtenerUsuarioPorId(request.getIdProfesor());
        if (!profesor.getRol().getRol().equals("profesor")) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El usuario no es un profesor");
        }
        cursoRepositoryPort.crearCurso(construirCursoDto(request, profesor));
    }

    @Override
    public void matricularEstudiante(Integer idCurso, Integer idEstudiante) {

    }

    private CursoDto construirCursoDto(CursoRequest request, UsuarioDto profesor) {
        return CursoDto.builder()
                .nombre(request.getNombre())
                .codigo(request.getCodigo())
                .profesor(profesor)
                .build();
    }
}
