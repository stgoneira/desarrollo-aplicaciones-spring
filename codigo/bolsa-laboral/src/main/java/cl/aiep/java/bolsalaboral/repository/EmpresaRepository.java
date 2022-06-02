package cl.aiep.java.bolsalaboral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.bolsalaboral.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
