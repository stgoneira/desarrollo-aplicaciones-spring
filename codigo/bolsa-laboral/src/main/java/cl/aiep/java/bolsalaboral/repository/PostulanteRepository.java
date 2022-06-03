package cl.aiep.java.bolsalaboral.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.bolsalaboral.model.Postulante;

public interface PostulanteRepository extends JpaRepository<Postulante, Long> {

	public Optional<Postulante> findByEmail(String email); 	
}
