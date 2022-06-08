package cl.aiep.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.model.Postulacion;

public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {

}
