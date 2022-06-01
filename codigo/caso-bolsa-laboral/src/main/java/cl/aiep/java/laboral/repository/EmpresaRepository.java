package cl.aiep.java.laboral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.laboral.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
