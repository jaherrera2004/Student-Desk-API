package com.studendesk.infrastructure.persistence.entity;

import com.studendesk.infrastructure.persistence.entity.configuracion.GeneroEntity;
import com.studendesk.infrastructure.persistence.entity.configuracion.RolEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;
    private String contrasenia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol")
    private RolEntity rol;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genero")
    private GeneroEntity genero;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CursoEntity> cursosDictados;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "estudiantes_cursos",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private Set<CursoEntity> cursos;
}
