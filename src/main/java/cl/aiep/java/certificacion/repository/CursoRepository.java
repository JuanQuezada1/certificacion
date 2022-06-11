package cl.aiep.java.certificacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.java.certificacion.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}