package com.studendesk.domain.model.dto;


import com.studendesk.domain.model.dto.config.GeneroDto;
import com.studendesk.domain.model.dto.config.RolDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDto {

    private Integer id;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String email;
    private String username;
    private String contrasenia;
    private RolDto rol;
    private GeneroDto genero;

}
