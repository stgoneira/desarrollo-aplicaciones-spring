package cl.aiep.java.laboral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.laboral.model.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {

}
