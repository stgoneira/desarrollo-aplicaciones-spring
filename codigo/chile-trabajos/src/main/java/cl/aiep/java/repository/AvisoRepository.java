package cl.aiep.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.model.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {

}
