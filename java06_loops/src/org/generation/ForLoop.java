package org.generation;

public class ForLoop {

	public static void main(String[] args) {
		/*
		 * Sintaxis:
		 * 
		 * for( expresion_inicial ; comparacion; expresion_final) instrucción;
		 * 
		 * for( expresion_inicial ; comparacion; expresion_final){ 
		 *   instrucciones; 
		 * }
		 * 
		 * Los bucles se usan para ejecutar un bloque de código
		 * repetidamente mientras se cumpla una condición. Son 
		 * fundamentales para tareas como recorrer arrays, procesar 
		 * colecciones de datos o simplemente repetir una acción 
		 * un número determinado de veces.
		 * 
		 * Bucle for:
		 * Es ideal cuando sabes de antemano cuántas veces quieres 
		 * que se repita el bloque de código.
		 * 
		 */
		for (int iteracion = 1; iteracion < 6; iteracion++) {
			System.out.println("Iteración: " + iteracion);
		}
		

		// Ejercicio mental ====================================
		int iteracion = 1;

		for (;;) {
			if (iteracion > 5)
				break;
			System.out.println("Núm. Iteración: " + iteracion++); // 1-5
		}

		System.out.println("Valor final de iteracion: " + iteracion); // 6
		
		// --------------------------------------------------------
		/*
		 * Una label (etiqueta) en Java es un identificador que le pones 
		 * a un bucle para poder controlarlo desde adentro de otro 
		 * bucle anidado.
		 * 
		 * Su uso principal es con las sentencias break y continue 
		 * para especificar a cuál bucle de una serie de bucles anidados 
		 * quieres afectar. Sin una etiqueta, break o continue siempre 
		 * se aplican al bucle más interno.
		 */
		ciclo:
		for (int i = 0; i < 5; i++) { 
			System.out.println("Valor de i: " + i); // 0-4
			if( i > 3 ) break ciclo;
		}
		// Qué imprime valor de i?
		
		
		// --------------------------------------------------------
		
		// Tabla de multiplicación del 1 al 10
		principal:
		for (int i = 1; i <= 5; i++) {
			
			secundario:
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j) );
				if ( j >= 7 ) break principal; 
			}							
		}	
		// Qué tablas de multiplicar se imprime? 1*1 - 1*7 
		
		// --------------------------------------------------------
		
		for (int i = 1; i <= 20; i++) {
			if( i % 2 == 0 ) continue;
			System.out.println("Valor impar: " + i);
		}
		// Que numeros se imprimen? impares del 1 al 19
		
		
		
		
		
		
		
		
		
	}

}
