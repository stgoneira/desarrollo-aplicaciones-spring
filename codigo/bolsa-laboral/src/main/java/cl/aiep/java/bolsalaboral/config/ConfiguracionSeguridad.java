package cl.aiep.java.bolsalaboral.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(
	prePostEnabled = true,
	securedEnabled = true,
	jsr250Enabled = true
)
@EnableWebSecurity
public class ConfiguracionSeguridad {

	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests( authorize -> authorize
						.mvcMatchers("/", "/aviso/crear","/empresa/registro", "/postulante/registro").permitAll()
						.mvcMatchers("/empresa/**").hasAuthority("EMPRESA") 
						.mvcMatchers("/postulante/**").hasAuthority("POSTULANTE")
						.anyRequest().authenticated() 
			)
			.formLogin(form -> form 
						.loginPage("/ingreso") 
						.defaultSuccessUrl("/", true) 
						.permitAll()
			)
			.logout(logout -> logout 
						.logoutRequestMatcher(
							new AntPathRequestMatcher("/salir", "GET")
						)						
			)
		;
		return http.build();
	}
	
}
