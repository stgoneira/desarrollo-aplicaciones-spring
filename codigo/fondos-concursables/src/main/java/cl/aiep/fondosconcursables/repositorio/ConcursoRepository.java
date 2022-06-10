package cl.aiep.fondosconcursables.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.fondosconcursables.modelo.Concurso;

public interface ConcursoRepository extends JpaRepository<Concurso, Long> {

}
