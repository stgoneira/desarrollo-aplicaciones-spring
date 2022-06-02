package cl.aiep.java.bolsalaboral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.aiep.java.bolsalaboral.model.Postulante;
import cl.aiep.java.bolsalaboral.repository.PostulanteRepository;

@Service 
public class PostulanteService {

	@Autowired 
	private PostulanteRepository repositorio;
	
	@Autowired 
	private PasswordEncoder codificadorContrasena;
	
	public Postulante crearPostulante(Postulante postulante) {
		String contrasenaCodificada = codificadorContrasena
										.encode( postulante.getContrasena() ); 
		postulante.setContrasena(contrasenaCodificada);
		return repositorio.save(postulante);
	}
	
}
