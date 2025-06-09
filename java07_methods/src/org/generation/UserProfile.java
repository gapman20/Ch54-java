package org.generation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  Las funciones(métodos) son fundamentales por:
 *  
 *  - Reutilización del código.
 *  - Organizar el código.
 *  - Facilidad de depuración.
 *  - Mejora la legibilidad.
 *  - Abstracción: encapsular la lógica de una tarea
 *  
 *  https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
 *  Sintaxis de un método:
 *  
 *   <modificadores_de_acceso> <tipo_retorno> nombreMétodo( parámetros ) <lista_de_excepciones> {
 *   
 *      // cuerpo del método
 *   }
 *   
 *   Modificadores de acceso: public, protected, default, private.
 *   Tipo retorno: Especifica el tipo de valor que el método devolverá( return ).
 *   		Si el método no devuelve ningún valor(String, int, etc), 
 *   		se usa la palabra reservada "void".
 *   Nombre del método: Se recomienda comenzar el nombre con un verbo, 
 *   		seguido por un adjetivo, sustantivo, etc. Usar la convención camelCase.
 *   Parámetros: Lista de parámetros separados por coma.
 *   
 *   La firma del método es como:
 *   nombreMétodo( double, int, double, double  )
 *   
 *  
 */
public class UserProfile {
	
	/**
	 * Javadoc es el generador de documentación estándar de Oracle 
	 * para el lenguaje Java. Utiliza comentarios especiales en el 
	 * código fuente para generar una documentación completa en 
	 * formato HTML sobre las clases, métodos y atributos de un programa.
	 * 
	 * Usa comentarios para explicar lógica compleja, no para describir 
	 * lo que el código ya dice. Los comentarios ayudan a entender 
	 * rápidamente cómo usar tu código sin necesidad de leer toda 
	 * la implementación.
	 * 
	 * Las siguientes tags comienzan con @ que describen partes 
	 * específica del código. 
	 * 
	 * Verificar si una cadena de texto tien un formato de email.
	 * 
	 * @param email email a validar.
	 * @return true si el email es válido, de lo contrario false.
	 */
	boolean isValidEmail( String email) {
		if( email == null  || email.trim().isEmpty() ) {
			return false;
		}
		
		boolean evaluation = email.contains("@") && email.contains(".");
		
		return evaluation;
	}
	
	
	/**
	 * Formatea un nombre de usuario a minúsculas y sin espacios(al inicio y al final)
	 * @param username El nombre de usuario a formatear
	 * @return El nombre de usuauro formateado( sin espacio y en minúsculas)
	 */
	String nameFormatted (String name) {
		return name.toLowerCase().trim();
	}
	
	/**
	 * Método sin retorno
	 * Imprimir un mensaje de error en la consola.
	 * No devuelve ningún valor, solo realiza la acción de imprimir
	 * @param message El mensaje de erro a mostrar
	 * 
	 */
	void logError(String message ) {	
		// Obtener la fecha y hora actual del sistema
		LocalDateTime now = LocalDateTime.now();
		
		// Formatear la fecha y hora
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		// Aplicar el formato a la fecha y hora actual
		String formattedTimestamp = now.format(formatter);
		
		System.err.println(formattedTimestamp +  " - Error: " + message);
	}

}
