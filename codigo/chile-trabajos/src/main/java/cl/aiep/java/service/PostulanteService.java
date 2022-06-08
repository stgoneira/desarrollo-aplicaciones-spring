package cl.aiep.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.aiep.java.model.Postulante;
import cl.aiep.java.repository.PostulanteRepository;

@Service
public class PostulanteService {

	@Autowired 
	private PostulanteRepository repository;
	
	@Autowired 
	private PasswordEncoder codificadorPassword;
	
	public Postulante crearPostulante(Postulante postulante) {
		String contrasenaCodificada = codificadorPassword.encode(
			postulante.getContrasena() 
		);
		postulante.setContrasena(contrasenaCodificada);
		return repository.save(postulante);
	}
	
}
