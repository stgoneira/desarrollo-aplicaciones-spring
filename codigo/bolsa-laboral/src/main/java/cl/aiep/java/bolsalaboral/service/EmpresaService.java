package cl.aiep.java.bolsalaboral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.aiep.java.bolsalaboral.model.Empresa;
import cl.aiep.java.bolsalaboral.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired 
	private EmpresaRepository repositorio; 
	
	@Autowired
	private PasswordEncoder codificadorContrasena;
	
	public Empresa crearEmpresa(Empresa empresa) {
		String contrasenaCodificada = codificadorContrasena
							.encode(empresa.getContrasena());
		empresa.setContrasena(contrasenaCodificada);
		return repositorio.save(empresa); 
	}

	public long contarEmpresas() {
		return repositorio.count();
	}
	
}
