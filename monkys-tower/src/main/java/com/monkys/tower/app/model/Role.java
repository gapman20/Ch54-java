package com.monkys.tower.app.model;
/**
 * Un POJO (Plain Old Java Object) es una clase Java simple, 
 * que no hereda ni depende de clases específicas
 * 
 * Características:
 *  - Tiene atributos privados.
 *  - Usa getters y setters.
 *  - Puede tener un constructor vacío y otro con parámetros.
 *  - No contiene lógica de negocio compleja ni anotaciones 
 *  especiales.
 */
public class Role {
	
	private Long id;
	private String name;
	private String description;
	
	public Role() {
		
	}

	public Role(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
