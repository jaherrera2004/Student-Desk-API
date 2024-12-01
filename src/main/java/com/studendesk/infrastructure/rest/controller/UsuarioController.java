package com.studendesk.infrastructure.rest.controller;

import com.studendesk.domain.consts.DatosGenerales;
import com.studendesk.domain.model.request.UsuarioRequest;
import com.studendesk.domain.model.response.GenericResponse;
import com.studendesk.application.service.interfaces.UsuarioIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(DatosGenerales.BASE_PATH+"/usuarios")
public class UsuarioController {

    private final UsuarioIService usuarioService;

    @PostMapping
    public GenericResponse registrarUsuario(@RequestBody UsuarioRequest request) {
        usuarioService.registrarUsuario(request);
        return GenericResponse.ok(true, "Usuario registrado correctamente");
    }
}
