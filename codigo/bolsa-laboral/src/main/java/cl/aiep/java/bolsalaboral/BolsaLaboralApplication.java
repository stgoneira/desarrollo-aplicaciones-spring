package cl.aiep.java.bolsalaboral;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.aiep.java.bolsalaboral.model.Empresa;
import cl.aiep.java.bolsalaboral.model.Postulante;
import cl.aiep.java.bolsalaboral.service.EmpresaService;
import cl.aiep.java.bolsalaboral.service.PostulanteService;

@SpringBootApplication
public class BolsaLaboralApplication {

	public static void main(String[] args) {
		SpringApplication.run(BolsaLaboralApplication.class, args);
	}

	@Bean
	public CommandLineRunner datosIniciales(EmpresaService empresaService, PostulanteService postulanteService) {
		return args -> {
			if( empresaService.contarEmpresas() == 0) {
				Empresa empresa = Empresa.builder() 
									.rut("76888999-k") 
									.razonSocial("Prueba SpA") 
									.email("contacto@prueba.cl")
									.contrasena("4321")
									.build();
				empresaService.crearEmpresa(empresa);
				
				empresa = Empresa.builder() 
						.rut("99888777-6") 
						.razonSocial("Nueva Era S.A.") 
						.email("contacto@nuevaera.cl")
						.contrasena("1111")
						.build();
				empresaService.crearEmpresa(empresa);
				
				Postulante postulante = Postulante.builder() 
											.rut("12345678-5") 
											.nombre("Ramón González")
											.email("ramon@123.cl") 
											.contrasena("1234")
											.build();
				postulanteService.crearPostulante(postulante);
			}
		};
	}
	
}
