package cl.aiep.java.laboral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.laboral.model.Postulacion;

public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {

}
