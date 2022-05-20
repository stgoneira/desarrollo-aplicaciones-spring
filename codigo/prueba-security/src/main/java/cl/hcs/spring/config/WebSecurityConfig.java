package cl.hcs.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import cl.hcs.spring.service.MiServicioUserDetails;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MiServicioUserDetails userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth 
			.userDetailsService(userDetailService)
			.passwordEncoder( passwordEncoder )
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize 
				.mvcMatchers("/", "/nosotros", "/contacto", "/usuario/crear").permitAll()
				.mvcMatchers("/admin/usuarios").access("hasRole('ADMIN') and hasRole('SUPERADMIN')")
				.mvcMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin(form -> form 
				.loginPage("/ingreso")
				.defaultSuccessUrl("/")
				.permitAll()
			)
			.logout(logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/salir", "GET"))
			)
		;		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web 
			.ignoring() 
			.mvcMatchers("/img/**", "/css/**", "/js/**") 
		;
	}

	
	
}
