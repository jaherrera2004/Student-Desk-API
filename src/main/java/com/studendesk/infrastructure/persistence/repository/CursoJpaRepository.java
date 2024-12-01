package com.studendesk.infrastructure.persistence.repository;

import com.studendesk.infrastructure.persistence.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoJpaRepository extends JpaRepository<CursoEntity, Integer> {
}
