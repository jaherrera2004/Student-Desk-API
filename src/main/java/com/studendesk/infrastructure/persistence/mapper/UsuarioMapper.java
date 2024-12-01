package com.studendesk.infrastructure.persistence.mapper;

import com.studendesk.domain.model.dto.UsuarioDto;
import com.studendesk.infrastructure.persistence.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioEntity toEntity(UsuarioDto usuarioDto);

    UsuarioDto toDto(UsuarioEntity usuarioEntity);
}
