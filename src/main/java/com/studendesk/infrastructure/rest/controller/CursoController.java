package com.studendesk.infrastructure.rest.controller;

import com.studendesk.application.service.interfaces.CursoIService;
import com.studendesk.domain.consts.DatosGenerales;
import com.studendesk.domain.model.request.CursoRequest;
import com.studendesk.domain.model.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(DatosGenerales.BASE_PATH+"/cursos")
public class CursoController {

    private final CursoIService cursoService;

    @PostMapping
    @PreAuthorize("hasAuthority('curso:crear')")
    public GenericResponse crearCurso(@RequestBody CursoRequest request) {
        cursoService.crearCurso(request);
        return GenericResponse.ok(true, "Curso creado correctamente");
    }

    @PostMapping("/{idCurso}/{idEstudiante}")
    public GenericResponse matricularEstudiante(@PathVariable Integer idCurso,@PathVariable Integer idEstudiante) {
        return null;
    }
}
