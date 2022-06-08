package cl.aiep.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.aiep.java.model.Empresa;
import cl.aiep.java.repository.EmpresaRepository;

@Service 
public class EmpresaService {

	@Autowired 
	private EmpresaRepository repository;
	
	@Autowired 
	private PasswordEncoder codificadorPassword;
	
	public Empresa crearEmpresa(Empresa empresa) {
		String contrasenaCodificada = codificadorPassword.encode(
			empresa.getContrasena() 
		);
		empresa.setContrasena(contrasenaCodificada);
		return repository.save(empresa);
	}
	
	public long contarEmpresas() {
		return repository.count();
	}
	
}
