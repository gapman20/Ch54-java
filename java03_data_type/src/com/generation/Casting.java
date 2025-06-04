package com.generation;

public class Casting { // inicia la clase

	public static void main(String[] args) { // inicia el método main
		/*
		 *  El orden de la jerarquía depende del tamaño de bits
		 *  y la precisión. El orden de jerarquía de los datos
		 *  primitivos de menor a mayor es:
		 *  
		 *  1.- byte (8 bits)
		 *  2.- short (16 bits)
		 *  3.- int (32 bits)
		 *  4.- long (64 bits)
		 *  5.- float (32 bits)
		 *  6.- double (64 bits)
		 * 
		 *  El Java las conversiones de tipo se llaman type casting.
		 *  Hay dos tipos principales: implicit casting y explicit casting)
		 * 
		 */
		
		// ================== Conversión implícita ==========================
		// Java convierte automáticamente un tipo más pequeño a uno más grande
		// 0: inactivo, 1:activo, 2: agotado, 3: descontinuado
		byte productStatusCode = 3;
		short statusCode = productStatusCode;
		
		
		// ================== Conversión explícita ==========================
		/*
		 * Se debe hacer manualmente colocando el tipo de dato entre paréntesis
		 * delante del valor a convertir.
		 * Es necesario cuando se convierte un tipo de dato más grnade a uno
		 * más pequeño.
		 * 
		 * ¡Cuidado! La conversión implícita puede llevar a la pérdida de 
		 * información si el valor del tipo más grande excede la capacidad
		 * del tipo más pequeño.
		 * 
		 * sintaxis:
		 *     (TipoAConvertir) dato
		 */
		short calificacionBuroDeCredito = 131;
		byte calificacion = (byte)calificacionBuroDeCredito;
		System.out.println("Valor de calificación: " + calificacion); // -125
		
		int numCohortes = 5;
		byte numTotal = (byte)numCohortes;
		
		System.out.println("Num. total: " + numTotal); // 5
		

	} // termina el método main

} // termina la clase
