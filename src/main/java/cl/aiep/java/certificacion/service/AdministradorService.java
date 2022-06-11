package cl.aiep.java.certificacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.aiep.java.certificacion.model.Administrador;
import cl.aiep.java.certificacion.repository.AdministracionRepository;

@Service
public class AdministradorService {

	@Autowired
	AdministracionRepository administradorRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public Administrador crearAdmin(Administrador admin) {
		String passCodificado = encoder.encode(admin.getPassword());
		admin.setPassword(passCodificado);
		return administradorRepository.save(admin);
	}
	
	public long contarAdmin() {
		return administradorRepository.count();
	}
}
