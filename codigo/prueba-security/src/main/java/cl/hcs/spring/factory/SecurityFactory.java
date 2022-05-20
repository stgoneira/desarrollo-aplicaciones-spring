package cl.hcs.spring.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityFactory {

	@Bean
	public PasswordEncoder codificadorDeContrasenas() {
		return new BCryptPasswordEncoder();
	}
	
}
