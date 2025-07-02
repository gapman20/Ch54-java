package com.monkys.tower.app.security.jwt;

import java.io.IOException;
import java.util.Collection;

import org.json.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * STEP 4. Recuperar el email y passor del cuerpo
 * de la solicitud de localhost:8080/login
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	// STEP 4.1 Recuperar email y password
	@Override
	public Authentication attemptAuthentication(
			HttpServletRequest request, 
			HttpServletResponse response
			)throws AuthenticationException {
		
		AuthCredentials authCredentials = new AuthCredentials();
		
		try {
			authCredentials = new ObjectMapper()
					.readValue( request.getReader(), AuthCredentials.class );
			
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		var username = new UsernamePasswordAuthenticationToken(
				authCredentials.getEmail(), 
				authCredentials.getPassword()
				);
			
		return getAuthenticationManager().authenticate(username);
	}
	
	// STEP 4.2 Si la autentication fue correcta agregamos el token a la respuesta
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain chain,
			Authentication authResult
			) throws IOException, ServletException {
		
		String email = authResult.getName();
		
		// STEP 5, Llamar a la utilería que genera el JWT
		Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
		String token = TokenUtils.createToken("--", email, authorities);
		
		// Configuración de la respuesta
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Authorization", "Bearer " + token);
		
		// Optional: crear un Objeto JSON para la respuesta
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("token", token);		
		response.getWriter().write( jsonResponse.toString() );
		response.getWriter().close();
		
		super.successfulAuthentication(request, response, chain, authResult);
	}
	

}
