package cl.aiep.java.laboral.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.laboral.model.Postulante;

public interface PostulanteRepository extends JpaRepository<Postulante, Long> {

	Optional<Postulante> findByEmail(String email);
}
