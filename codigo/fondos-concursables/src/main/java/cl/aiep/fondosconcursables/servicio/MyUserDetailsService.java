package cl.aiep.fondosconcursables.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.aiep.fondosconcursables.modelo.Administrador;
import cl.aiep.fondosconcursables.modelo.Empresa;
import cl.aiep.fondosconcursables.repositorio.AdministradorRepository;
import cl.aiep.fondosconcursables.repositorio.EmpresaRepository;
import cl.aiep.fondosconcursables.seguridad.Usuario;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired 
	EmpresaRepository empresaRepository;
	
	@Autowired
	AdministradorRepository administradorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Administrador> adminOpt = administradorRepository.findById(username);
		if( adminOpt.isPresent() ) {
			return new Usuario(adminOpt.get());
		} else {
			Optional<Empresa> empresaOpt = empresaRepository.findByRut(username);
			if( empresaOpt.isPresent() ) {
				return new Usuario(empresaOpt.get());
			}
		}
		throw new UsernameNotFoundException("Usuario no existe!!!");
	}
	
}
