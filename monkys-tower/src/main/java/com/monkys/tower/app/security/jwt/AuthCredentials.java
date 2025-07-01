package com.monkys.tower.app.security.jwt;

/**
 * STEP 3
 * Crear la clase que servirá para la autenticación /login
 * del usuario
 */
public class AuthCredentials {
	
	private String email;
	private String password;
	
	public AuthCredentials() {
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
