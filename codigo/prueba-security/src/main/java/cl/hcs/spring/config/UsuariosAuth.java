package cl.hcs.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class UsuariosAuth {

	@Bean
	public UserDetailsService usuarios() {
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		UserDetails user1 = userBuilder
								.username("santiago")
								.password("1234")
								.roles("USER")
								.build()
		;
		UserDetails user2 = userBuilder
				.username("admin")
				.password("9876")
				.roles("ADMIN")
				.build()
		;		
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
}
