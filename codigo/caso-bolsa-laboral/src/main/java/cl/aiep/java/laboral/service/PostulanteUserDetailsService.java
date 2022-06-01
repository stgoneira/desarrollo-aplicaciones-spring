package cl.aiep.java.laboral.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.aiep.java.laboral.model.Postulante;
import cl.aiep.java.laboral.repository.EmpresaRepository;
import cl.aiep.java.laboral.repository.PostulanteRepository;

@Service
public class PostulanteUserDetailsService implements UserDetailsService {

	@Autowired 
	private PostulanteRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Postulante> postulante = repository.findByEmail(username);
		if( postulante.isPresent() ) {
			return buildUserDetails( postulante.get() );
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado!!!");
		}
	}

	private UserDetails buildUserDetails(Postulante postulante) {
		UserDetails user = User.builder()
			.username( postulante.getEmail() ) 
			.password( postulante.getContrasena() ) 
			.authorities("ROLE_USER")
			.build()
		;
		return user;
	}

}
