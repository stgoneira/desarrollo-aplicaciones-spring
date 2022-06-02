package cl.aiep.java.bolsalaboral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.java.bolsalaboral.model.Empresa;
import cl.aiep.java.bolsalaboral.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired 
	private EmpresaRepository repositorio; 
	
	public Empresa crearEmpresa(Empresa empresa) {
		return repositorio.save(empresa); 
	}
	
}
