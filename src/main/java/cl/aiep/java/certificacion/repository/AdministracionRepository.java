package cl.aiep.java.certificacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.java.certificacion.model.Administrador;

@Repository
public interface AdministracionRepository extends JpaRepository<Administrador, Long> {

	Optional<Administrador> findByUsername(String username);

}
