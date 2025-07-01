package com.monkys.tower.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.monkys.tower.app.security.jwt.JWTAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

/**
* @EnableWebSecurity: habilita la configuración de seguridad web 
*   en una aplicación Spring Boot.
* @Configuration: contiene configuraciones para la aplicación, 
*  como definiciones de beans y configuración de componentes, 
*  y que debe ser considerada durante la inicialización del 
*  contexto de la aplicación.
*
*/
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
	
	// STEP 1 Autenticacion basada en usuarios en memoria
	/**
	 * La anotación @Bean en Spring Boot se utiliza para 
	 * registrar un objeto (un "bean") en el contenedor de 
	 * Spring. Esto permite que Spring gestione el ciclo 
	 * de vida de este objeto y lo puedas inyectar en otras 
	 * partes de tu aplicación.
	 * 
	 */
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails sergio = User.builder()
				.username("sergio")
				.password("$2a$10$7phOzlVq8x6fH.aWKnLJzOABfQW3TMRlMcM.L42tmltKGPLf8hPOq") // 123
				.roles("ADMIN") // ROLE_ADMIN
				.build();
		UserDetails nancy = User.builder()
				.username("nancy")
				.password("$2a$10$3rkDMZJ.Zz2CwwUnBdpOpOBHhGRjpCFt13m6J3CCfEOii7FWcIXmC") // magic
				.roles("CUSTOMER") // ROLE_CUSTOMER
				.build();
		UserDetails jesus = User.builder()
				.username("jesus")
				.password("$2a$10$ndSYkq1SBRC6wsbCulMJUOAxNTULPGsWMYGehETfmpFnvZ8dGmlPa") // lors
				.roles("CUSTOMER","ADMIN") // ROLE_CUSTOMER, ROLE_ADMIN
				.build();
		
		return new InMemoryUserDetailsManager(sergio, nancy, jesus);
	}
	
	// STEP 1.1 Crear un bean de PassworsEncoder
	/**
	 *  Crear un bean de BCryptPasswordEncoder.
	 *  BCrypPasswordEncoder es una implementación de PasswordEncoder proporcionada
	 *  por Spring Security. Se utiliza para codificar y verificar contraseñas utilizando
	 *  el algoritmo de hashing bcrypt.
	 *  El algoritmo incorpora un sal aleatoria por cada contraseña, lo que agrega un capa
	 *  adicional de seguridad.
	 */	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Generar el hash encriptado de una contraseña
	 * 
	 */
	public static void main(String[] args) {
		System.out.println( new BCryptPasswordEncoder().encode("lors") );
	}
	
	// STEP 2 Configuraciones personalizar al filter chain
	/**
	 * HttpSecurity es el objeto principal que te permite configurar 
	 * todas las reglas de seguridad web en Spring Security. 
	 * Funciona como un constructor (builder) que usas para definir 
	 * cómo se deben manejar las peticiones HTTP.
	 * 
	 * La protección CSRF(Cross-Site Request Forgery) es crucial para 
	 * aplicaciones web tradicionales con sesiones y formularios. 
	 * Sin embargo, para APIs REST stateless (que usan tokens como JWT), 
	 * esta protección no es necesaria y se suele deshabilitar, ya que 
	 * la autenticación no se basa en cookies de sesión que el navegador 
	 * envía automáticamente.
	 * 
	 * httpBasic: Es un mecanismo de seguridad simple donde el navegador 
	 * envía el usuario y la contraseña en cada petición, codificados en 
	 * Base64. Generalmente, provoca que el navegador muestre una 
	 * ventana emergente nativa pidiendo credenciales.
	 * 
	 * withDefaults(): Se usa principalmente para pruebas rápidas o en 
	 * APIs donde no se requiere un flujo de login complejo con formularios.
	 * 
	 * 
	 * @throws Exception 
	 */
	// STEP 2.1 Deshabilitar la seguridad
	/*@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests( authorize-> authorize
						.anyRequest()
						.permitAll() )
				.csrf( csrf-> csrf.disable())
				.httpBasic( withDefaults() ) 
				.build();
	}*/
	
	//STEP 2.2 Personalizar la seguridad en los enpoints
	/**
	 * authorizeHttpRequests() es el método principal que se 
	 * usa en Spring Security para definir las reglas de 
	 * autorización. Es el punto de entrada donde decides 
	 * quién puede acceder a qué URLs en tu aplicación.
	 * 
	 * - Matcher (.requestMatchers(...)): Primero, seleccionas un 
	 *  conjunto de URLs (y/u opcionalmente, un método HTTP como GET, POST).
	 * - Regla (.permitAll(), .hasRole(...), etc.): Luego, aplicas una 
	 *  regla de seguridad a las URLs que seleccionaste.
	 */
	@Bean
	SecurityFilterChain filterChain(
			HttpSecurity http,
			AuthenticationConfiguration authConfig
			) throws Exception {
		
        // STEP 4.3.1: Obtén el AuthenticationManager desde la configuración de Spring.
        // Este manager ya sabe cómo usar tu UserDetailsService y PasswordEncoder.
        AuthenticationManager authenticationManager = authConfig.getAuthenticationManager();

		// STEP 4.3.2 Crear el objeto y la configuración para jwtAuthenticationFilter
		var jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		
		
		return http
				.authorizeHttpRequests( authorize-> authorize
						.requestMatchers("/","/login","index.html","style.css","/src/**").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/v1/users").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/v1/roles").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/api/v1/products").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/api/v1/products").hasAnyRole("ADMIN", "CUSTOMER")
						.anyRequest().authenticated() )
				// STEP 4.4 Agregar el filtro de autentication del login
				// Interceptar la solicitud de autenticacion y generar el JWT en la respuesta
				.addFilter(jwtAuthenticationFilter)
				.csrf( csrf-> csrf.disable())
				.httpBasic( withDefaults() ) 
				.build();
	}

	
}
