package com.studendesk.infrastructure.persistence.adapter;

import com.studendesk.domain.exceptions.HttpGenericException;
import com.studendesk.domain.model.dto.UsuarioDto;
import com.studendesk.domain.repositoryPort.UsuarioRepositoryPort;
import com.studendesk.infrastructure.persistence.mapper.UsuarioMapper;
import com.studendesk.infrastructure.persistence.repository.UsuarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registrarUsuario(UsuarioDto usuarioDto) {
        usuarioDto.setContrasenia(passwordEncoder.encode(usuarioDto.getContrasenia()));
        usuarioRepository.save(usuarioMapper.toEntity(usuarioDto));
    }

    @Override
    public UsuarioDto obtenerUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .map(usuarioMapper::toDto)
                .orElse(null);
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDto)
                .orElseThrow(() -> new HttpGenericException(HttpStatus.BAD_REQUEST, "Usuario no encontrado"));
    }

    @Override
    public boolean existeUsuarioPorUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    @Override
    public boolean existeUsuarioPorEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
