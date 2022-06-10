package cl.aiep.fondosconcursables.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.aiep.fondosconcursables.modelo.Empresa;
import cl.aiep.fondosconcursables.repositorio.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	public Empresa crearEmpresa(Empresa empresa) {
		String contrasenaCodificada = passwordEncoder.encode(empresa.getContrasena());
		empresa.setContrasena(contrasenaCodificada);
		return repository.save(empresa);
	}
}
