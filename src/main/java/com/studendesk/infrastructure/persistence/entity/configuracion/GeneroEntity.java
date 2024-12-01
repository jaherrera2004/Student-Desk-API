package com.studendesk.infrastructure.persistence.entity.configuracion;

import com.studendesk.infrastructure.persistence.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "generos")
public class GeneroEntity {

    @Id
    private Integer id;
    private String genero;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsuarioEntity> usuarios;
}
