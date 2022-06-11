package cl.aiep.fondosconcursables.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ConfiguracionSeguridad {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filtros(HttpSecurity http) throws Exception {
		http 
			.authorizeHttpRequests( authorize -> authorize 
										.anyRequest().permitAll()
			)
			.formLogin( login -> login 
							.loginPage("/ingreso")
							.defaultSuccessUrl("/", true)
							.permitAll()
			)
			.logout( logout -> logout 
						.logoutRequestMatcher(new AntPathRequestMatcher("/salir", "GET"))
						.logoutSuccessUrl("/") 
			)
		;
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer customizer() {
		return (web) -> web 
						.ignoring().mvcMatchers("/img/**", "/css/**", "/js/**") 
		;
	}
}
