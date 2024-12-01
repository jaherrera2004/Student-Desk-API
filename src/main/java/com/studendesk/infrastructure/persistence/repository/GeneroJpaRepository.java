package com.studendesk.infrastructure.persistence.repository;

import com.studendesk.infrastructure.persistence.entity.configuracion.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroJpaRepository extends JpaRepository<GeneroEntity, Integer> {
}
