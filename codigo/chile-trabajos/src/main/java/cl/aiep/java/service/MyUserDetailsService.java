package cl.aiep.java.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.aiep.java.model.Empresa;
import cl.aiep.java.model.Postulante;
import cl.aiep.java.repository.EmpresaRepository;
import cl.aiep.java.repository.PostulanteRepository;
import cl.aiep.java.seguridad.Usuario;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired	
	private PostulanteRepository postulanteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
							throws UsernameNotFoundException {
		Optional<Postulante> postulanteOpt = postulanteRepository.findByEmail(username);
		if( postulanteOpt.isPresent() ) {
			return new Usuario(postulanteOpt.get(), null);
		} else {
			Optional<Empresa> empresaOpt = empresaRepository.findByRut(username);
			if( empresaOpt.isPresent() ) {
				return new Usuario(null, empresaOpt.get());
			}
		}
		throw new UsernameNotFoundException("Usuario no encontrado!!!");
	}

}
