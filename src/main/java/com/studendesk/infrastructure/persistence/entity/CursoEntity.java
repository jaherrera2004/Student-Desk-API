package com.studendesk.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cursos")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String codigo;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private UsuarioEntity profesor;

    @ManyToMany(mappedBy = "cursos", fetch = FetchType.LAZY)
    private List<UsuarioEntity> estudiantes;

}
