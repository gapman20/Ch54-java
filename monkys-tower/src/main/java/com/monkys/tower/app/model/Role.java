package com.monkys.tower.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
 *  
 * @Entity se usa para marcar una clase como una entidad que se puede persistir
 *         en una base de datos relacional.
 * 
 *         Se indica a JPA que la clase representa una tabla en la base de datos
 *         y que los objetos de esta clase puedan ser almacenados, actualizados
 *         o eliminados en dicha tabla. Además, cada instancia se la clase se
 *         considera una fila en la tabla.
 */

@Entity
@Table(name="roles")
public class Role {
	
	@Id // El atributo será la clave primaria
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name", length=50, nullable=false)
	private String name;
	@Column(name="description", length=100, nullable=true)
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


/*
 * GenerationType.AUTO: Esta estrategia le permite al proveedor de JPA elegir
 * automáticamente la estrategia de generación más adecuada según la base de
 * datos y la configuración. El comportamiento exacto puede variar dependiendo
 * del proveedor utilizado.
 * 
 * GenerationType.IDENTITY: Esta estrategia utiliza una columna de identidad de
 * la base de datos para generar automáticamente los valores de la clave
 * primaria. Es compatible con bases de datos como MySQL que admiten columnas de
 * autoincremento. En este caso, la base de datos se encarga de generar y
 * asignar el valor de la clave primaria.
 * 
 * GenerationType.SEQUENCE: Esta estrategia utiliza una secuencia de la base de
 * datos para generar automáticamente los valores de la clave primaria. Se
 * requiere que la base de datos admita secuencias. El proveedor de JPA utiliza
 * la secuencia definida en la base de datos para obtener los valores de la
 * clave primaria.
 * 
 * GenerationType.TABLE: Esta estrategia utiliza una tabla especial en la base
 * de datos para generar los valores de la clave primaria. Se crea una tabla
 * separada que registra los valores generados para cada entidad. El proveedor
 * de JPA consulta esta tabla para obtener el próximo valor de la clave
 * primaria.
 * 
 * GenerationType.UUID: Esta estrategia genera un UUID versión 4. Se basa 
 * en números aleatorios y no en atributos del sistema (como timestamps).
 * 
 */
