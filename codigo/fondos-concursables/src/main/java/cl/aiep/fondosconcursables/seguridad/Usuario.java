package cl.aiep.fondosconcursables.seguridad;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cl.aiep.fondosconcursables.modelo.Administrador;
import cl.aiep.fondosconcursables.modelo.Empresa;

public class Usuario implements UserDetails {

	private static final long serialVersionUID = -1206664527070545909L;
	
	private Administrador administrador;
	private Empresa empresa;
	
	// CONSTRUCTORES 
	public Usuario(Administrador administrador) {
		this.administrador = administrador;
	}
	
	public Usuario(Empresa empresa) {
		this.empresa = empresa;
	}
	// END CONSTRUCTORES 
	
	
	// GETTERS 
	public Administrador getAdministrador() {
		return administrador;
	}

	public Empresa getEmpresa() {
		return empresa;
	}
	// END GETTERS
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if( administrador != null ) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
		if( empresa != null ) return List.of(new SimpleGrantedAuthority("ROLE_EMPRESA"));
		return null;
	}

	@Override
	public String getPassword() {
		if( administrador != null ) return administrador.getContrasena();
		if( empresa != null ) return empresa.getContrasena();
		return null;
	}

	@Override
	public String getUsername() {
		if( administrador != null ) return administrador.getUsuario();
		if( empresa != null ) return empresa.getRazonSocial(); 
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
