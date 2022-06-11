package cl.aiep.java.certificacion;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.aiep.java.certificacion.model.Administrador;
import cl.aiep.java.certificacion.model.Curso;
import cl.aiep.java.certificacion.model.Estudiante;
import cl.aiep.java.certificacion.repository.CursoRepository;
import cl.aiep.java.certificacion.service.AdministradorService;
import cl.aiep.java.certificacion.service.UsuarioService;

@SpringBootApplication
public class CertificacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CertificacionApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner datosIniciales(AdministradorService aService, UsuarioService uService, CursoRepository cRepo) {
		return args -> {
			if(aService.contarAdmin() == 0) {
				Administrador admin = Administrador.builder()
													.username("admin")
													.password("1234")
													.build();
				aService.crearAdmin(admin);
														
			}
			
			if(uService.contarUsuarios() == 0) {
				Estudiante estudiante = Estudiante.builder()
											.nombre1("Juan")
											.nombre2("Pablo")
											.apellidoPaterno("Quezada")
											.apellidoMaterno("Delgado")
											.direccion("No disponible")
											.region("No disponible")
											.telefono("912345678")
											.email("correo@dominio.com")
											.rut("12345678-9")
											.password("1234")
											.region("No disponible")
											.comuna("No disponible")
											.build()
									;
				uService.crearUsuario(estudiante);
			}
			if(cRepo.count() == 0) {
				Curso cursoJava = Curso.builder()
										.nombre("Fundamentos de Programacion en Java")
										.fechaInicio(LocalDate.of(2023, 6, 1))
										.fechaFin(LocalDate.of(2023, 8, 1))
										.cupos(30)
										.descripcion("Curso Lenguaje de programación JAVA en el cual aprenderán a diseñar aplicaciones orientadas a objeto, crear programas mediante actividades prácticas.")
										.imagen(Files.readAllBytes(Paths.get("src/main/resources/static/LogosCursos/java.png")))
										.build();
				Curso cursoSpring = Curso.builder()
										.nombre("Desarrollo Web con Spring Framework")
										.fechaInicio(LocalDate.of(2023, 9, 1))
										.fechaFin(LocalDate.of(2023, 12, 1))
										.cupos(30)
										.descripcion("Este curso está orientado al sector de las técnologias TI o desarrollo de software que deseen utilizar Framework Spring, para entender la forma tradicional de trabajo XML y su transición a boot.")
										.imagen(Files.readAllBytes(Paths.get("src/main/resources/static/LogosCursos/spring.png")))
										.build();
				Curso cursoOracle = Curso.builder()
										.nombre("Bases de Datos Relacionales con Oracle")
										.fechaInicio(LocalDate.of(2023, 6, 15))
										.fechaFin(LocalDate.of(2023, 8, 15))
										.cupos(30)
										.descripcion("Este curso te aportará los conocimientos necesarios para instalar, configurar y mantener las bases de datos Oracle, Oracle Database y MySQL.")
										.imagen(Files.readAllBytes(Paths.get("src/main/resources/static/LogosCursos/oracle.png")))
										.build();
				cRepo.save(cursoJava);
				cRepo.save(cursoSpring);
				cRepo.saveAndFlush(cursoOracle);
			}
		};
	}
	
	

}