package com.studendesk.infrastructure.persistence.entity.configuracion;

import com.studendesk.infrastructure.persistence.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class RolEntity {

    @Id
    private Integer id;
    private String rol;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsuarioEntity> usuarios;
}
