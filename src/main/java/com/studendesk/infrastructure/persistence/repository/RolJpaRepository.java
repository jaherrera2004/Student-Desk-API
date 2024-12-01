package com.studendesk.infrastructure.persistence.repository;

import com.studendesk.infrastructure.persistence.entity.configuracion.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolJpaRepository extends JpaRepository<RolEntity, Integer> {
}
