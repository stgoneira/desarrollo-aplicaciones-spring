package cl.aiep.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.aiep.java.model.Empresa;
import cl.aiep.java.model.Postulante;
import cl.aiep.java.service.EmpresaService;
import cl.aiep.java.service.PostulanteService;

@SpringBootApplication
public class ChileTrabajosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChileTrabajosApplication.class, args);
	}

	@Bean 
	public CommandLineRunner datosIniciales(
			PostulanteService postulanteService
			, EmpresaService empresaService) {
		return args -> {
			if( empresaService.contarEmpresas() == 0 ) {
				Empresa empresa = Empresa.builder() 
									.razonSocial("Prueba SpA") 
									.rut("78999555-k") 
									.contrasena("1234") 
									.email("contacto@prueba.cl") 
									.build();
				empresaService.crearEmpresa(empresa);
				
				empresa = Empresa.builder() 
						.razonSocial("Trabajando S.A.") 
						.rut("99888777-6") 
						.contrasena("5555") 
						.email("contacto@trabajando.cl") 
						.build();
				empresaService.crearEmpresa(empresa);
							
				// =============================================
				
				Postulante postulante = Postulante.builder() 
										.nombre("Juan Perez")
										.rut("12345678-5")
										.email("juan@123.cl") 
										.contrasena("4321") 
										.build();
				
				postulanteService.crearPostulante(postulante);
				
				postulante = Postulante.builder() 
						.nombre("Ramón González")
						.rut("8765432-1")
						.email("ramon@123.cl") 
						.contrasena("9876") 
						.build();
				postulanteService.crearPostulante(postulante);
			}
		};
	}
	
}
