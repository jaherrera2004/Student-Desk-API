package com.studendesk.infrastructure.persistence.mapper;

import com.studendesk.domain.model.dto.config.GeneroDto;
import com.studendesk.infrastructure.persistence.entity.configuracion.GeneroEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneroMapper {
    GeneroDto toDto(GeneroEntity generoEntity);

    GeneroEntity toEntity(GeneroDto generoDto);
}
