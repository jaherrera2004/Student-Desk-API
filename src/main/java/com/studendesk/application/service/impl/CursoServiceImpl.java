package com.studendesk.application.service.impl;

import com.studendesk.application.service.interfaces.CursoIService;
import com.studendesk.domain.emailSenderPort.EmailSenderPort;
import com.studendesk.domain.emailSenderPort.TIPOS_CORREOS;
import com.studendesk.domain.exceptions.HttpGenericException;
import com.studendesk.domain.model.dto.CursoDto;
import com.studendesk.domain.model.dto.UsuarioDto;
import com.studendesk.domain.model.request.CursoRequest;
import com.studendesk.domain.repositoryPort.CursoRepositoryPort;
import com.studendesk.domain.repositoryPort.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CursoServiceImpl implements CursoIService {

    private final CursoRepositoryPort cursoRepositoryPort;
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final EmailSenderPort emailSenderPort;

    @Override
    public void crearCurso(CursoRequest request) {

        UsuarioDto profesor = usuarioRepositoryPort.obtenerUsuarioPorId(request.getIdProfesor());
        if (!profesor.getRol().getRol().equals("Profesor")) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "El usuario no es un profesor");
        }
        CursoDto cursoDto = construirCursoDto(request, profesor);

        cursoRepositoryPort.crearCurso(cursoDto);
        emailSenderPort.enviarCorreo(profesor.getEmail(),cursoDto, TIPOS_CORREOS.NUEVO_CURSO);
    }

    @Override
    public void matricularEstudiante(Integer idCurso, Integer idEstudiante) {

    }

    @Override
    public List<CursoDto> obtenerCursosPorProfesor(Integer idProfesor) {
        List<CursoDto> cursos = cursoRepositoryPort.obtenerCursosPorProfesor(idProfesor);
        cursos.forEach(curso -> curso.setProfesor(null));
        return cursos;
    }

    @Override
    public CursoDto obtenerCursoPorId(Integer idCurso) {
        CursoDto curso = cursoRepositoryPort.obtenerCursoPorId(idCurso);
        curso.setProfesor(null);
        return curso;
    }

    private CursoDto construirCursoDto(CursoRequest request, UsuarioDto profesor) {
        return CursoDto.builder()
                .nombre(request.getNombre())
                .codigo(request.getCodigo())
                .descripcion(request.getDescripcion())
                .profesor(profesor)
                .build();
    }
}
