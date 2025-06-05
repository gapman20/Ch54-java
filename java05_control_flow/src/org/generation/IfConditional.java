package org.generation;

public class IfConditional {

	public static void main(String[] args) {
		/**
		 * 
		 * Flujos de control: las sentencias de flujo de control interrumpen el flujo de
		 * ejecución empleando toma de decisiones, bucles y ramificaciones lo que
		 * permite que el programa ejecute condicionalmente bloques de código
		 * particulares.
		 * 
		 * Sintaxis de la condicional if Si la condicional es verdadera, se ejecuta la
		 * instrucción de if
		 * 
		 * if ( condicional ) sentencia;
		 * 
		 * if ( condicional ) { 
		 *    sentencias; 
		 * }
		 * 
		 * if ( condicional ) sentencia; 
		 * else sentencia_Si_condicional_es_falsa;
		 * ------------------------------------------------------ 
		 * if ( condicional )
		 *   sentencia; 
		 * else if ( nueva_condicional) 
		 *   sentencia; 
		 * else if ( n_condición )
		 *   sentencia; 
		 * else 
		 *   sentencia;
		 * 
		 */
		
		/*
		 * De una variable tipo int, evaluar si está en el rango de 1 a 10, si es así
		 * desplegar en consola "La selección está en el rango" En caso contrario
		 * "La selección está fuera de rango"
		 */
		int num = 10;
		if (num >= 1 && num <= 10) {
			System.out.println("La seleccion esta en el rango");
		} else {
			System.out.println("La seleccion esta fuera de rango");
		}
		
		int rango = 2;
		if( rango == 15)    ;
		
		{
			System.out.println("El número es igual a 15"); // siempre se imprime
		}
		
		/*
		 * Operador ternario.
		 * 
		 * Sintaxis: expresión ? respuesta_si_es_verdadera : si_es_falsa
		 *
		 * El operador ternario en Java, también conocido como operador 
		 * condicional, es una forma concisa de escribir una sentencia 
		 * if-else simple. Permite asignar un valor a una variable 
		 * o ejecutar una expresión basándose en una condición booleana.
		 *
		 * Si las expresiones o la condición son muy complejas, el 
		 * operador ternario puede volverse difícil de leer y entender. 
		 * En esos casos, es preferible usar una sentencia if-else 
		 * tradicional.
		 *
		 * Realizar el ejercicio anterior usado el operador ternario
		 */
		int num2 = 10;
		String mensaje = (num2 >= 10)? "Si es mayor" : "No es mayor";
		System.out.println(mensaje);
		
		int value = 5;
		System.out.println("La selección está " +
			    ((value >= 1 && value <= 10) ? "en el rango" : "fuera de rango" )
			);
		
		// Si es miembro premium, obtiene 15% de descuento, sino 5%
		// Imprimir en consola el porcentaje asignado
		boolean isPremiumMember = false;
		int discountPercentage;

		String texto = (isPremiumMember == true? "descuento 15%" : "descuento 5%");
		System.out.println(texto);
		
	
		if(isPremiumMember == true) {
			// discountPercentage = 15;
			System.out.println("Tu descuento de premium es del 15%");
		}
		else { 
			System.out.println("Tu descuento de mortal es del 5%");
		}
		
	}

}
