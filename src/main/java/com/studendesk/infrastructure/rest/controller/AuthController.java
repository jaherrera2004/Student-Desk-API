package com.studendesk.infrastructure.rest.controller;

import com.studendesk.application.service.interfaces.AuthIService;
import com.studendesk.domain.consts.DatosGenerales;
import com.studendesk.domain.model.request.AuthRequest;
import com.studendesk.domain.model.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(DatosGenerales.BASE_PATH+"/auth")
public class AuthController {

    private final AuthIService authService;

   @PostMapping
    public AuthResponse iniciarSesion(@RequestBody AuthRequest request) {
        return authService.iniciarSesion(request);
    }
}
