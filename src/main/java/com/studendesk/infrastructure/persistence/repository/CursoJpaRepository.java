package com.studendesk.infrastructure.persistence.repository;

import com.studendesk.infrastructure.persistence.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoJpaRepository extends JpaRepository<CursoEntity, Integer> {

    @Query(value = "INSERT INTO estudiantes_cursos (id_curso, id_estudiantes) " +
            "VALUES (:idCurso, :idEstudiante)", nativeQuery = true)
    void matricularEstudiante(@Param("idCurso") Integer idCurso, @Param("idEstudiante") Integer idEstudiante);

    List<CursoEntity> findCursoEntitiesByProfesor_Id(Integer idProfesor);
}
