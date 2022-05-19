package cl.hcs.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.hcs.spring.model.Usuario;
import cl.hcs.spring.repository.UsuarioRepository;

@Service
public class MiServicioUserDetails implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(username);
		if( usuarioOptional.isPresent() ) {
			return buildUserDetails(usuarioOptional.get());
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}

	private UserDetails buildUserDetails(Usuario usuario) {
		User.UserBuilder builder = User.builder();
		Collection<GrantedAuthority> roles = buildAuthorities(usuario);
		builder 
			.username( usuario.getUsuario() )
			.password( usuario.getContrasena() )
			.authorities( roles )
		;
		return builder.build();
	}

	private Collection<GrantedAuthority> buildAuthorities(Usuario usuario) {
		HashSet<GrantedAuthority> roles = new HashSet<>();
		for(String rol : usuario.getRoles().split(",")) {
			roles.add(new SimpleGrantedAuthority(rol));
		}
		return roles;
	}

	
	
}
