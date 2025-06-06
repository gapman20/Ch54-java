package org.generation;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		/*
		 * La clase Scanner en Java se utiliza para 
		 * leer datos de entrada de diferentes fuentes, 
		 * como la consola, archivos o flujos de texto. 
		 * Es especialmente útil para interactuar con 
		 * el usuario mediante la consola.
		 * 
		 * La clase Scanner en Java es una clase útil 
		 * que se encuentra en el paquete java.util
		 * 
		 * System.in: Representa la entrada del teclado
		 */
		 Scanner sc = new Scanner( System.in );
		 
		 System.out.print("Escribe tu nombre: ");
		 
		/*
		 * Lee una línea completa de entrada como cadena de texto.
		 * Devuelve todo el texto de la línea, excluyendo el
		 * carácter de salto de línea(\n).
		 * 
		 * Buffer: Memoria temporal donde se almacenan los datos
		 * de entrada antes de ser procesados.
		 */
		 String name = sc.nextLine();
		 System.out.println("Quiubole " + name);
		 
		 System.out.print("Dime tu número de la suerte (1-10): ");
		 if( sc.hasNextInt() ) {
			 int myNumber = sc.nextInt();
			 System.out.println("Genial, tú número de la suerte es: " + myNumber);			 
		 } else {
			 System.out.println("Eres un mal usuario, no entregaste un número");
		 }
		 /*
		  * Se recomienda usar nextLine() adicional para
		  * capturar el salto de línea que quedó tras la entrada de nextInt()
		  */
		 sc.nextLine();
		 
		 System.out.print("Qué personaje de Shrek eres? ");
		 String personaje = sc.nextLine();
		 System.out.println("Eres el personaje " + personaje);
		 
		 
		 /*
		  * Cerrar el scanner y liberar los recursos del sistema
		  */
		 sc.close();

	}

}
