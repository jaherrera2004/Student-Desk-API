package com.studendesk.domain.model.request;


import lombok.Data;

@Data
public class UsuarioRequest {

    private Integer id;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String email;
    private String username;
    private String contrasenia;
    private Integer idRol;
    private Integer idGenero;

}
