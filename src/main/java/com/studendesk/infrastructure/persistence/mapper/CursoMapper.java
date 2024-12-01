package com.studendesk.infrastructure.persistence.mapper;

import com.studendesk.domain.model.dto.CursoDto;
import com.studendesk.infrastructure.persistence.entity.CursoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    CursoDto toDto(CursoEntity cursoEntity);

    CursoEntity toEntity(CursoDto cursoDto);
}
