package cl.aiep.java.laboral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.aiep.java.laboral.model.Postulante;
import cl.aiep.java.laboral.repository.PostulanteRepository;

@Service
public class PostulanteService {
	
	@Autowired 
	private PostulanteRepository repository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;

	public Postulante crearPostulante(Postulante postulante) {
		postulante.setContrasena( passwordEncoder.encode(postulante.getContrasena()) );
		return repository.save(postulante);
	}
	
	public long cantidadPostulantes() {
		return repository.count();
	}
	
}
