package cl.aiep.fondosconcursables.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.fondosconcursables.modelo.Empresa;
import cl.aiep.fondosconcursables.modelo.Postulacion;

public interface PostulacionRepository
	extends JpaRepository<Postulacion, Long> {

	public long countByEmpresa(Empresa empresa);
	
	public List<Postulacion> findByEmpresa(Empresa empresa);
	public List<Postulacion> findByEmpresa_Id(Long empresaId);
	
}
