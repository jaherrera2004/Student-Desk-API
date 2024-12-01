package com.studendesk.application.service.impl;

import com.studendesk.application.service.interfaces.AuthIService;
import com.studendesk.domain.consts.Permisos;
import com.studendesk.domain.exceptions.HttpGenericException;
import com.studendesk.domain.model.dto.UsuarioDto;
import com.studendesk.domain.model.request.AuthRequest;
import com.studendesk.domain.model.response.AuthResponse;
import com.studendesk.domain.repositoryPort.UsuarioRepositoryPort;
import com.studendesk.infrastructure.rest.security.CustomUserDetails;
import com.studendesk.application.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthIService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse iniciarSesion(AuthRequest request) {

        UsuarioDto usuarioDto = usuarioRepositoryPort.obtenerUsuarioPorUsername(request.getUsername());

        if (usuarioDto == null) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Usuario o contraseña incorrectos");
        }

        if (!passwordEncoder.matches(request.getContrasenia(), usuarioDto.getContrasenia())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Usuario o contraseña incorrectos");
        }

        List<String> permisos = Arrays.asList(Permisos.obtenerPermisos(usuarioDto.getRol().getRol()));

        List<SimpleGrantedAuthority> authorities = permisos
                .stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(authorities);
        String rol= usuarioDto.getRol().getRol();
        CustomUserDetails customUserDetails = new CustomUserDetails(usuarioDto.getId(), request.getUsername(), "", rol, grantedAuthorities);

        String token = jwtService.generateToken(customUserDetails, permisos, usuarioDto.getId(), rol);
        return new AuthResponse("Bienvenido "+usuarioDto.getUsername()+ "!",token);
    }
}
