package cl.aiep.java.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.file.entity.Archivo;

public interface ArchivoRepository extends JpaRepository<Archivo, Long> {

}
