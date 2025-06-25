package com.monkys.tower.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.monkys.tower.app.model.Role;
import com.monkys.tower.app.repository.RoleRepository;
@Component
public class RoleDataLoader implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// Crear un nuevo rol
		System.out.println("Probando el CRUD con role");
		roleRepository.save( new Role(null, "ADMIN", "Administrador de mi ecommerce"));
	}

}
