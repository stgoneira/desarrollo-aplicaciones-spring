package cl.hcs.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize 
				.mvcMatchers("/", "/nosotros", "/contacto").permitAll()
				.mvcMatchers("/admin/usuarios").access("hasRole('ADMIN') and hasRole('SUPERADMIN')")
				.mvcMatchers("/admin/**").hasRole("ADMIN")
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

	
	
}
