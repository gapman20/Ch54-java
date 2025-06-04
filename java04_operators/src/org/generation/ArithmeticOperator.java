package org.generation;

import java.util.ArrayList;

public class ArithmeticOperator {
	
	int counter = 1;
	static String cohorte;
	
 	public static void main(String[] args) {
		/* Arithmetic Operators
		  
	 	+	Additive operator (also used for String concatenation)
		-	Subtraction operator
	 	*	Multiplication operator
		/	Division operator
		%	Remainder operator
	 
	 Cuando se realizan operaciones entre tipo de datos diferentes
	 el resultado es promovido al de mayor jerarquía para evitar
	 pérdida de precisión.
	 
	 Ejemplo:   int * long = long
	 
	 *  1.- byte (8 bits)
	 *  2.- short (16 bits)
	 *  3.- int (32 bits)
	 *  4.- long (64 bits)
	 *  5.- float (32 bits)
	 *  6.- double (64 bits)
	 
	 */
		double value =  5.2;
		int operatorA = (int)value; // 5
		int operatorB = 6;
		int sum = operatorA + operatorB;
		System.out.println("Sumatoria: " + sum); // 11
		
		int difference = operatorA - operatorB;
		System.out.println("Resta: " + difference); // -1
		
		double product = operatorA * 1.2;
		int product2 = operatorA * (int)1.2; // 5
		int product3 = (int)(operatorA * 1.2); // 6
		var product4 = operatorA * 1.2; // 6.0
		
		System.out.println(product); // 6.0
		System.out.println(product2); // 5
		System.out.println(product3); // 6
		System.out.println(product4); // 6.0 double
		
		/*
		 * Java tiene varios tipos de datos numéricos para 
		 * optimizar el uso de memoria y mejorar el rendimiento, 
		 * ofreciendo flexibilidad para elegir el tipo adecuado 
		 * según el contexto y las necesidades del programa.
		 * 
		 * En ciclos o en bloques de código donde se realizan 
		 * muchas operaciones repetitivas, como iteraciones, 
		 * es recomendable usar tipos como int para evitar 
		 * conversiones innecesarias entre tipos y así 
		 * mejorar el rendimiento.
		 * 
		 */
		/*
		byte interes = 1;
		byte resultado;
		for (int i = 0; i < 10; i++) {
			resultado = (byte)(5 * interes);
		}
		*/
		int interes = 1;
		int resultado;
		for (int i = 0; i < 10; i++) {
			resultado = 5 * interes;
		}
		
		
		/*
		 *  Palabra reserva "var"
		 *  Se introdujo en la versión de Java 10.
		 * 
		 *  Se utiliza para la inferencia de tipo de variable locales.
		 *  
		 *  Uso principal: simplica la declaración de variables locales,
		 *     especialmente cuando el tipo de dato es largo.
		 *     
		 *  Consideraciones:
		 *   - Solo para variables locales
		 *   - La variable debe ser inicializada en la misma declaración.
		 */
		// int itemCount = 10;
		var itemCount = 20;
		var firstChar = "L";
		
		System.out.println( itemCount ); // dato de tipo int
		System.out.println( firstChar ); // String
		
		
	}

	public void printMyString() {
		// var userList = new ArrayList<String>();
		ArrayList<String> userList = new ArrayList<>();
	}
}
