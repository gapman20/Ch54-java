package com.monkys.tower.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.monkys.tower.app.model.Role;
import com.monkys.tower.app.repository.RoleRepository;

/**
* CommandLineRunner es una interfaz en Spring Boot que se 
* usa para ejecutar código específico una vez que la 
* aplicación ha iniciado completamente. Es particularmente 
* útil para ejecutar tareas de inicialización o configuración 
* cuando se arranca la aplicación.
* 
* @Order(n) se utiliza para controlar el orden de ejecución 
* de los beans que implementan interfaces como CommandLineRunner 
* o ApplicationRunner
*/
@Component
@Order(1)
@Profile("h2") // Para que se active cuando se use el perfil indicado
public class RoleDataLoader implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;
	/**
	 *  - Logger permite definir niveles( TRACE, DEBBUG, INFO, WARN, ERROR).
	 *  - Redirigir el log a archivos, bases de datos o consola.
	 *  - Personalizar el formato.
	 *  - Se integra mejor con otras herramientas para un monitoreo avanzado
	 */
	private static final Logger log = LoggerFactory.getLogger( RoleDataLoader.class );


	
	@Override
	public void run(String... args) throws Exception {
		// Crear un nuevo rol
		System.out.println("Probando el CRUD con role");
		roleRepository.save( new Role(null, "ADMIN", "Administrador de mi ecommerce"));
		roleRepository.save(new Role(null, "GUESTS", "Invitado en mi ecommerce"));
		roleRepository.save(new Role(null, "CUSTOMER", "cliente de mi ecommerce"));
		
		// ===== Leer todos lo roles ===========
		// Crear un nuevo rol
		//System.out.println("============= Leyendo todos los roles =============");
		log.info("============= Leyendo todos los roles =============");
		Iterable<Role> roles = roleRepository.findAll();
		for(Role role : roles) {
			//System.out.println("Rol Encontrado: " + role );
			log.info("Rol encontrado: {}", role);
		}
		
		
	}

}
