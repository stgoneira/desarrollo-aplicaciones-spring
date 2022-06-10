package cl.aiep.fondosconcursables.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.aiep.fondosconcursables.modelo.Administrador;
import cl.aiep.fondosconcursables.repositorio.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	public Administrador crearAdministrador(Administrador administrador) {
		String contrasenaCodificada = passwordEncoder.encode(administrador.getContrasena());
		administrador.setContrasena(contrasenaCodificada);
		return repository.save(administrador);
	}
	
}
