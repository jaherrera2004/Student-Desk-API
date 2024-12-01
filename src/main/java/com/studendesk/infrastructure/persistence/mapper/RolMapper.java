package com.studendesk.infrastructure.persistence.mapper;

import com.studendesk.domain.model.dto.config.RolDto;
import com.studendesk.infrastructure.persistence.entity.configuracion.RolEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDto toDto(RolEntity rolEntity);

    RolEntity toEntity(RolDto rolDto);
}
