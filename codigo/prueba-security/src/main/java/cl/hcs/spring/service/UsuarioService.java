package cl.hcs.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.hcs.spring.model.Usuario;
import cl.hcs.spring.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario crearUsuario(Usuario usuario) {
		String contrasenaCodificada = bCryptPasswordEncoder.encode(usuario.getContrasena()); 
		usuario.setContrasena(contrasenaCodificada);
		return usuarioRepository.save(usuario);
	}
	
}
