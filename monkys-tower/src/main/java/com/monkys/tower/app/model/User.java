package com.monkys.tower.app.model;

import java.time.*;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	@Column(name = "phone_number", length = 20, nullable = true)
	private String phoneNumber;
	@Column(name = "birth_date", nullable = true)
	private LocalDate birthDate;
	@Column(name = "avatar_url", length = 255, nullable = true)
	private String avatarUrl;
	@Column(name = "is_active", nullable = false)
	private boolean active = true;
	
	// Hibernate asignará la fecha y hora de creación automáticamente
	// updatable/insertable : el campo no debe ser modificado manualmente
	//                    desde el código, dejando que Hibernate la gestione.
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	// Hibernate asignará la fecha y hora de actualización automáticamente
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	/**
     * Define una relación muchos a muchos entre la entidad 
     * User y la entidad Role.
     * Un cliente puede tener múltiples roles y un rol puede 
     * pertenecer a múltiples clientes.
     * 
     * La relación se gestiona mediante una tabla intermedia 
     * llamada "user_has_role".
     * - La columna "user_id" en la tabla intermedia 
     *   referencia a la entidad User.
     * - La columna "role_id" en la tabla intermedia 
     *   referencia a la entidad Role.
     *   
     *   FetchType.EAGER (Ansiosa)
     *    Se carga inmediatamente, junto con la entidad principal.
     *    Por default está configurado para: toOne
     *   FetchType.LAZY (Perezosa)
     *    Se carga solo cuando se accede a la relación por primera vez.
     *    Carga los roles SÓLO si se llama a user.getRoles()
     *    
     * LazyInitializationException: Ocurre cuando intentas acceder a una relación 
	 * de una entidad que ha sido configurada con carga perezosa (lazy loading), 
	 * pero la sesión de Hibernate o el contexto de persistencia ya está cerrado.
	 * 
	 * Esto es muy común cuando el método @Transactional está siendo llamado 
	 * desde fuera del proxy de Spring.
	 * 
	 * Asegúrate de acceder a la colección o entidad lazy mientras la sesión de 
	 * Hibernate sigue abierta (es decir, dentro del método @Transactional).
     *    
     * @ManyToMany: Define una relación de muchos a muchos. Un usuario puede tener muchos roles y viceversa.
     * fetch = FetchType.LAZY: Los roles no se cargarán hasta que se accedan explícitamente.
     * @JoinTable: Define la tabla intermedia que une 'users' y 'roles'.
     * - name = "users_has_roles": El nombre de la tabla de unión.
     * - joinColumns: La clave foránea que referencia a la entidad actual (User).
     * - inverseJoinColumns: La clave foránea que referencia a la otra entidad (Role).
     */
	@ManyToMany(fetch = FetchType.EAGER) // @OneToOne, @OneToMany, @ManyToOne  private User user
	// @JsonIgnoreProperties({field1, fiel2});
	@JoinTable( 
			name="user_has_role", 
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")			
			)
	private Set<Role> roles = new HashSet<>();
	
	public User() {}

	public User(Long id, String firstName, String lastName, String email, String password, String phoneNumber,
			LocalDate birthDate, String avatarUrl, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt,
			Set<Role> roles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.avatarUrl = avatarUrl;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.roles = roles;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getPhoneNumber() {
		return phoneNumber;
	}

	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public final LocalDate getBirthDate() {
		return birthDate;
	}

	public final void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public final String getAvatarUrl() {
		return avatarUrl;
	}

	public final void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public final boolean isActive() {
		return active;
	}

	public final void setActive(boolean active) {
		this.active = active;
	}

	public final LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public final void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public final LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public final void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public final Set<Role> getRoles() {
		return roles;
	}

	public final void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", avatarUrl=");
		builder.append(avatarUrl);
		builder.append(", active=");
		builder.append(active);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append("]");
		return builder.toString();
	}
	
	// Métodos de ayuda para sincronizar la relación bidireccional
    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }
	
	
	
}
