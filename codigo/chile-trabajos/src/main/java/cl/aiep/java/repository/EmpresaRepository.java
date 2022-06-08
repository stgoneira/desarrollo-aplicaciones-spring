package cl.aiep.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	public Optional<Empresa> findByRut(String rut); 
	
}
