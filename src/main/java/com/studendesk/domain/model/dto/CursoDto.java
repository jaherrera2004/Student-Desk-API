package com.studendesk.domain.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CursoDto {

    private Integer id;
    private String nombre;
    private String codigo;
    private UsuarioDto profesor;

}
