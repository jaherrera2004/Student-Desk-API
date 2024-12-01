package com.studendesk.application.service.impl;

import com.studendesk.domain.exceptions.HttpGenericException;
import com.studendesk.domain.model.dto.UsuarioDto;
import com.studendesk.domain.model.request.UsuarioRequest;
import com.studendesk.application.service.interfaces.UsuarioIService;
import com.studendesk.domain.repositoryPort.GeneroRepositoryPort;
import com.studendesk.domain.repositoryPort.RolRepositoryPort;
import com.studendesk.domain.repositoryPort.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioIService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final RolRepositoryPort rolRepositoryPort;
    private final GeneroRepositoryPort generoRepositoryPort;

    @Override
    public void registrarUsuario(UsuarioRequest request) {

        if (usuarioRepositoryPort.existeUsuarioPorUsername(request.getUsername())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST,"Este usuario ya esta registrado");
        }

        if (usuarioRepositoryPort.existeUsuarioPorEmail(request.getEmail())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST,"Este email ya esta registrado");
        }

        usuarioRepositoryPort.registrarUsuario(construirUsuarioDto(request));
    }

    public UsuarioDto construirUsuarioDto(UsuarioRequest request) {
        return UsuarioDto.builder()
                .nombre(request.getNombre())
                .nombre2(request.getNombre2())
                .apellido(request.getApellido())
                .apellido2(request.getApellido2())
                .email(request.getEmail())
                .username(request.getUsername())
                .contrasenia(request.getContrasenia())
                .rol(rolRepositoryPort.obtenerRolPorId(request.getIdRol()))
                .genero(generoRepositoryPort.obtenerGeneroPorId(request.getIdGenero()))
                .build();
    }
}
