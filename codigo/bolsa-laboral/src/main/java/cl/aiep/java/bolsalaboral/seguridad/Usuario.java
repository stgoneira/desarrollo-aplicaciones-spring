package cl.aiep.java.bolsalaboral.seguridad;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cl.aiep.java.bolsalaboral.model.Empresa;
import cl.aiep.java.bolsalaboral.model.Postulante;

public class Usuario implements UserDetails {

	private static final long serialVersionUID = 8034866848234915291L;
	private Empresa empresa;
	private Postulante postulante;
	
	public Usuario(Postulante postulante, Empresa empresa) {
		this.empresa 	= empresa;
		this.postulante = postulante;
	}
	
	public Empresa getEmpresa() {return empresa;}
	public Postulante getPostulante() {return postulante; }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if( postulante != null ) return List.of(new SimpleGrantedAuthority("POSTULANTE"));
		if( empresa != null ) return List.of(new SimpleGrantedAuthority("EMPRESA"));
		return null;
	}

	@Override
	public String getPassword() {
		if( postulante != null ) return postulante.getContrasena();
		if( empresa != null ) return empresa.getContrasena();
		return null;
	}

	@Override
	public String getUsername() {
		if( postulante != null ) return postulante.getNombre();
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
