package cl.aiep.fondosconcursables.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfiguracionSeguridad {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public SecurityFilterChain filtros(HttpSecurity http) throws Exception {
		http 
			.authorizeHttpRequests( authorize -> authorize 
										.anyRequest().permitAll()
			)
		;
		return http.build();
	}
	
}
