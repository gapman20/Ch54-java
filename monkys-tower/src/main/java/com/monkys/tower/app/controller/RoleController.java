package com.monkys.tower.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monkys.tower.app.model.Role;
import com.monkys.tower.app.service.RoleService;

/**
 * Anotación para configurar la política de Cross-Origin Resource Sharing (CORS).
 * 'origins = "*"' indica que este controlador aceptará solicitudes desde
 * cualquier origen (dominio).
 *
 * ADVERTENCIA: Usar "*" en producción es un riesgo de seguridad.
 * En un entorno real, especifica los dominios exactos desde donde
 * se permitirán las solicitudes (ej: "http://tufrontend.com").
 *
 * Propósito: Permite que un frontend alojado en un dominio/puerto diferente
 * se comunique con esta API REST sin ser bloqueado por la política
 * de seguridad del navegador. 
 * 
 * '@Controller': Indica que esta clase es un componente de tipo controlador
 * que maneja las solicitudes HTTP entrantes.
 * '@ResponseBody': Significa que el valor de retorno de los métodos de este
 * controlador será directamente el cuerpo de la respuesta HTTP.
 * Spring se encargará de convertir el objeto Java retornado
 * (normalmente a JSON o XML) antes de enviarlo al cliente.
 *
 * Propósito: Facilita la creación de servicios web RESTful al simplificar
 * el proceso de devolución de datos (en lugar de vistas).
 * 
 * @RequestMapping Anotación utilizada para mapear solicitudes HTTP a un manejador específico
 * (clase o método).
 *
 * Cuando se usa a nivel de clase (como aquí), define la URL base
 * para todos los endpoints (métodos) dentro de este controlador.
 *
 */
@CrossOrigin(origins = "*")
@RestController // @Controller y @ResponseBody
@RequestMapping("/api/v1/roles") 
public class RoleController {
	
	RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping // ("/api/v1/roles") http://localhost:8080/api/v1/roles
    Iterable<Role> getAllRoles(){
		Iterable<Role> roles = roleService.findAll();
		return roles;
	}
	
	/**
	 * La anotación @RequestBody se utiliza en métodos controladores de Spring 
	 * para indicar que el cuerpo de la solicitud HTTP entrante debe ser 
	 * mapeado a un objeto Java.
	 *
	 * Es comúnmente usada en solicitudes HTTP de tipo POST o PUT, donde 
	 * los datos se envían en el cuerpo del mensaje (generalmente en formato JSON).
	 *
	 * Spring se encarga automáticamente de convertir el JSON recibido al 
	 * objeto Java correspondiente, utilizando un convertidor como Jackson.
	 */
	@PostMapping
	Role createRole(@RequestBody Role role ) {
		Role newRole = roleService.save(role);
		return role;
	}
	
	/**
	 *  @GetMapping con Path Variable
	 *  Path Variable vincula un valor de una variable URL
	 *  a un parámetro del método.
	 *  Permite capturar datos dinámicos presentes en la URL 
	 */
	@GetMapping("/{id}") // localhost:8080/api/v1/roles/1
	Role getRoleById(@PathVariable("id") Long id) {
		Role existingRole = roleService.findById(id);
		return existingRole;
	}
	
}
