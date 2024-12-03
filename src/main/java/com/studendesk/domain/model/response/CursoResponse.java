package com.studendesk.domain.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CursoResponse {
    private Integer id;
    private String nombre;
    private String codigo;
    private String descripcion;
}
