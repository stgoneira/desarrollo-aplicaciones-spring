package cl.hcs.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.hcs.spring.controller.AppController;

@SpringBootTest
class PruebaWebApplicationTests {

	@Autowired
	private AppController appController;
	
	@Test
	void contextLoads() {
		assertThat(appController).isNotNull();
	}

}
