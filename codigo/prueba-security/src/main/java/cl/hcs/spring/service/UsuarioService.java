package cl.hcs.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.hcs.spring.model.Usuario;
import cl.hcs.spring.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario crearUsuario(Usuario usuario) {
		String contrasenaCodificada = passwordEncoder.encode(usuario.getContrasena()); 
		usuario.setContrasena(contrasenaCodificada);
		return usuarioRepository.save(usuario);
	}
	
}
