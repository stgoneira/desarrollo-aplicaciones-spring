package cl.aiep.java.laboral;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.aiep.java.laboral.model.Postulante;
import cl.aiep.java.laboral.repository.PostulanteRepository;
import cl.aiep.java.laboral.service.PostulanteService;

@SpringBootApplication
public class CasoBolsaLaboralApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasoBolsaLaboralApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner datosIniciales(PostulanteService service) {
		return args -> {
			if( service.cantidadPostulantes() == 0) {
				Postulante postulante = Postulante.builder()
						.contrasena("1234") 
						.email("prueba@123.cl") 
						.rut("12345678-5")
						.build()
				;
				service.crearPostulante(postulante);
			}
		};
	}

}
