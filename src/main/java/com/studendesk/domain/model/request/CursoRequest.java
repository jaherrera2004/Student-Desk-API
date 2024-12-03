package com.studendesk.domain.model.request;

import lombok.Getter;

@Getter
public class CursoRequest {

    private Integer id;
    private String nombre;
    private String codigo;
    private Integer idProfesor;
    private String descripcion;
}
