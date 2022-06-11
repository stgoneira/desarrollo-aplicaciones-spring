package cl.aiep.fondosconcursables.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.fondosconcursables.modelo.Concurso;

public interface ConcursoRepository extends JpaRepository<Concurso, Long> {

	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	public List<Concurso> findByTituloContaining(String titulo);
	
}
