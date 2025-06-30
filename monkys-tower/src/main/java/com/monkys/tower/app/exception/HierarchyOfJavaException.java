package com.monkys.tower.app.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Una excepción es una situación no esperada
 * durante la ejecución de un programa.
 * 
 * Existen dos tipos de excepciones.
 * 
 * A) Checked Exceptions: Son  excepciones que se heredan
 * de la clase Exceptions. Se tiene que declarar la excepción
 * en la firma del método o bien manejar la excepción con 
 * el bloque try-catch.
 * 
 * B) Unchecked Exceptions: Son excepciones que se heredan
 * de la clase RuntimeException. No se está obligado a procesarlas.
 * Es opcional el uso de try-catch o declar en la firma del método.
 * 
 * Las excepciones de Error, son arrojadas por la JVM, son errores
 * de los que no se pueden recuperar.
 * 
 * Manejo de excepciones con el bloque try-catch
 * 
 * Sintaxis:
 * 
 *  try{
 *  
 *  }
 *  catch(exception e  ){
 *  
 *  }
 * 
 * try: bloque que contendrá sentencias que pudieran generar una excepción.
 * catch: se ejecutará si ocurre una excepción en try
 * finally: se ejecutará después de try o catch.
 * 
 * El stacktrace de una excepción es el conjunto
 * de mensajes desde el origen de la excepción
 * hasta la última clase que recibe la excepción.
 * 
 * 
 */
public class HierarchyOfJavaException {
	
	public static void main(String[] args) {
		// Manejo de exepciones
		try {
			divideByZero(10);
			readFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (ArithmeticException e) {
//			e.printStackTrace();
		} catch ( Exception globalException) {
			System.out.println("Se ejecuta el manejo global de exepciones ");
			globalException.printStackTrace();
		}
		finally {
			System.out.println("Se ejecuta el bloque finally ");
		}
		System.out.println("Fin de mi programa ");

		
	}
	
	public static void readFile() throws FileNotFoundException {
		// Checked Exception
		File file = new File("src/myFile.txt");
		Scanner sc = new Scanner( file );
	}
	
	public static void divideByZero(int a) {
		// Unchecked Exception
		// ArithmeticException
		int result = a / 0;
	}

}
