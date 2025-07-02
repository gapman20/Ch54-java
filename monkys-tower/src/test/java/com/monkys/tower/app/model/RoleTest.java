package com.monkys.tower.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas Unitarias para el entidad Role")
public class RoleTest {
	
	Role role;
	
	@Test
	@DisplayName("Contructor sin argumentos: debe crear un objeto con valores por default")
	void testNoArgsConstructor() {
		//  Arrange (Preparación)
		role = new Role();
		
		// Assert (Verificaciones)
		assertNotNull(role);
		assertNull(role.getId());
		assertNull(role.getName());
		assertNull(role.getDescription());		
	}
	
	@Test
	@DisplayName("Contructor con argumentos: debe inicializar todos los campos correctamente")
	void testAllArgsConstructor() {
		// Arrange-Act-Assert (AAA)
		// Arrange (Preparación) Preparamos el escenario.
		Long id = 1L;
		String name = "ADMIN";
		String description = "Administrador del sistema";
		
		// Act (Acción) Ejecutamos el método a probar.
		role = new Role(id, name, description);
		
		// Assert (Verificar) Verificamos los resultados.
		assertNotNull( role );
		assertEquals(id, role.getId());
		assertEquals(name, role.getName());
		assertEquals(description, role.getDescription());
	}
	
	@Test
	@DisplayName("Get/Set: debe asignar y obtener el ID correctamente de los campos")
	void testSetAndGetAllFilds() {
		// Arrange
		Long id = 5L;
		String name = "USER";
		String description = "Usuario";
		role = new Role();
		// Act
		role.setId(id);
		role.setName(name);
		role.setDescription(description);
		// Asert
		assertEquals(id, role.getId());
		assertEquals(name, role.getName());
		assertEquals( description, role.getDescription());
	}
	
	

}
