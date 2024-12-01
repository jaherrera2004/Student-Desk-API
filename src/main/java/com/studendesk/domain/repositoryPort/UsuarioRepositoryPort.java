package com.studendesk.domain.repositoryPort;

import com.studendesk.domain.model.dto.UsuarioDto;

public interface UsuarioRepositoryPort {

    void registrarUsuario(UsuarioDto usuarioDto);

    UsuarioDto obtenerUsuarioPorUsername(String username);

    UsuarioDto obtenerUsuarioPorId(Integer id);

    boolean existeUsuarioPorUsername(String username);

    boolean existeUsuarioPorEmail(String email);
}
