package cl.aiep.fondosconcursables.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.fondosconcursables.modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	public Optional<Empresa> findByRut(String rut);
	
}
