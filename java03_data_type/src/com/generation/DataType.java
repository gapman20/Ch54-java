package com.generation;

public class DataType {

	public static void main(String[] args) {
		System.out.println("Sesión Java 03");
		// Comentario de línea
		/*
		 * Comentario de bloque
		 */
		/*
		 * 
		 * Reglas para el nombre de las variables: 
		 * - Se distingue entre minúsculas y mayúsculas 
		 * - La longitud del nombre es ilimitada 
		 * - Puedes utilizar cualquier caracter Unicode 
		 * - La variable puede comenzar: 
		 * > una letra ej. miVariable 
		 * > signo de dolar $miVariable 
		 * > caracter de subrayado _miVariable
		 * 
		 * Java es un lenguaje de programación 
		 * fuertemente tipado, lo que significa que 
		 * todas las variables deben ser declaradas 
		 * con un tipo de dato específico antes 
		 * de ser usadas.
		 * 
		 * [tipo de dato] [nombre de la variable]
		 *         String message;
		 * 
		 */
		int $myVar; // es válida, no se aconseja
		int _numEngranes; // es válida, no se aconseja
		int myVarEnEspañol; // es válida, se recomienda nombres en inglés
		int sinC0m3nt4r10s; // es válida, es confusa
		int val; // es válida, pero muy genérica
		boolean hasPaymentBeenProcessed; // válida y recomendada 
		String cfn; // válida, dificl de comprender
		
		
		/*
		 * En Java tendremos  los siguientes tipo de variables:
		 *  Variables de instancia (Non static fields): atributos de los objetos.
		 *  Variables de clase (Static Fields): atributos de la clase.
		 *  Variables locales (local variables): variable dentro de las funciones(métodos)
		 *  Parámetros (parameters): Entrada de las funciones
		 * 
		 */
		
		/**
		 *  https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
		 *  Tipos de datos en Java
		 *  - Objetos (no primitivos)
		 *  - Datos primitivos
		 *  	8 datos primitivos
		 *   > byte (8 bits)
		 *   > short (16 bits)
		 *   > int (32 bits)
		 *   > long (64 bits)
		 *   > float (32 bits)
		 *   > double (64 bits)
		 *   > boolean
		 *   > char (16 bits)
		 *      
		 */
		
		// El tipo byte es de 8 bits, almacena datos numéricos enteros
		byte smallNumber; // declarar la variable
		smallNumber = 100; // asignando un valor a la variable
		
		/*
		 *  El número de de dígitos que puede contener la varible
		 *  2^8 = 256;
		 *  2^7 = 128 -> 
		 *        128 valores positivos:  0 ... +127 
		 *        128 valores negativos: -1 ... -128 
		 *    
		 *  Para Obtener el valor máximo y mínimo del tipo byte
		 *  usando su wrapper (clase envolvete) Byte.
		 *  
		 *  usos: util para ahorrar memoria cuando los valores numéricos
		 *        son pequeños.
		 */
		System.out.println("Max value in byte type: " + Byte.MAX_VALUE ); // 127
		System.out.println("Min value in byte type: " + Byte.MIN_VALUE ); // -128
		
		/*
		 *  Tipo de dato short
		 *  Dato de 16 bits, almacena valores enteros
		 *  2^16 = 65536
		 *  Valores positivos:  0... 32767
		 *  Valores Negativos: -1... -32768
		 *  Obtener el MAX_VALUE y MIN_VALUE usando el warapper Short
		 *  
		 *  usos: util para ahorrar memoria cuando los valores numéricos
		 *        son pequeños. Sistemas embebidos con memoria limitada.
		 */
		System.out.println("Max Value in short type: " + Short.MAX_VALUE ); // 32767
		System.out.println("Max Value in short type: " + Short.MIN_VALUE ); // -32768
		short mediumNumber = 2000;
		
		/*
		 * Tipo de dato int
		 * Dato de 32 bits, almacena datos enteros.
		 * El wrapper de int es Integer
		 * 
		 * usos: Adecuado para la mayoría de los números: contadores,
		 *       índices de arreglos, cantidad de productos en inventario.
		 *       
		 * Obtener el rango máximo y mínimo del tipo int:      
		 */
		System.out.println("Max Value in int type: " + Integer.MAX_VALUE ); // 2147483647
		System.out.println("Min Value in int type: " + Integer.MIN_VALUE ); // -2147483648
			
		/*
		 * Tipo de dato long
		 * Dato de 64 bits, almacena datos enteros.
		 * El wrapper de long es Long
		 * 
		 * usos: IDs de transacciones bancarias, marcas de tiempo precisas,
		 *       IDs en grandes bases de datos.
		 */	
		System.out.println("Max value in long type: " + Long.MAX_VALUE); // 9223372036854775807
	    System.out.println("Max value in long type: " + Long.MIN_VALUE);  // -9223372036854775808
		
	    
	    /*
		 * Las literales numéricas enteras en java son de tipo int
		 * ej. 12, -456, 0
		 * Para idicar una literal numética de tipo long
		 * hay que indicar la literal con la letra l o L.
		 * Se recomienda usar la L para no confundir con el 1
		 * 
		 * Se puede utilizar _ para una mayor legibilidad en un
		 * valor numéricos.
		 */	    
	    long productId = 22_147_467_456L; 
	    
		// =========Datos de punto flotante===================================
		/*
		 * Dato de tipo float
		 * Dato de 32 bits, almacena valos numéricos de punto flotante.
		 * 
		 * El wrapper de float es Float.
		 * 
		 * usos: la precisión no necesita ser extremadamente alta y se busca
		 *       ahorrar memoria.
		 * 
		 * nota: tanto float como double tiene pérdida de precisión.
		 * Para evitar la pérdida de precisión se puede usar la clase BigDecimal
		 */
	    System.out.println("Max Value in float type: " + Float.MAX_VALUE);// 3.4028235E38
		System.out.println("Min Value in float type: " + Float.MIN_VALUE);// 1.4E-45

		System.out.println( .1 + .2 ); // 0.30000000000000004
	    
	    /*
		 * Dato de tipo double
		 * Dato de 64 bits, almacena valos numéricos de punto flotante.
		 * 
		 * El wrapper de double es Double.
		 * 
		 * uso: se elige double para cálculos que requieran alta exactitud como cálculos
		 *     científicos, coordenadas geográficas.
		 * 
		 * nota: Para cálculos financieros críticos, la clase BigDecimal es más
		 *       recomendada.
		 */
		System.out.println("Max value in data double type: " + Double.MAX_VALUE); // 1.7976931348623157E308
		System.out.println("Max value in data double type: " + Double.MIN_VALUE); // 4.9E-324
		
	    /*
		 *  Las literales de punto flotante son por default double(64)
		 *  ej. 123.567, 0.012, -0.989
		 */
		float productRatingAverage = 4.7F;
		
		 /*
		 * Dato Boolean
		 * Almacena valores true o false.
		 * 
		 * El wrapper es Boolean.
		 */
		boolean isActive = true;
		
		/*
		 * Dato char
		 * Almacena un solo caracter.
		 * Se debe definir la literal con apóstrofe ej. 'a', 'C', ' '
		 * Solo almacea caracteres de la tabla unicode(16 bits).
		 * puede almacenar del 0 al 65535
		 */
	
		  // Tienes que maneja las tallas S, M, L
		 char productSizeCode = 'L';
		 System.out.println("Talla: " + productSizeCode ); // L
		 // Asignarle la letra M usando su valor unicode
		 productSizeCode = '\u004D';
		 System.out.println("Talla: " + productSizeCode ); // M
		 // Asignarle la letra S usando su valor numérico
		 productSizeCode = 83;
		 System.out.println("Talla: " + productSizeCode ); // S
		 // Asignar la letra X usando unicode o su valor numérico
		 productSizeCode = 88;
		 productSizeCode = '\u0058';
		 System.out.println("Talla: " + productSizeCode ); // X
		
		/*
		 * Formas de representar un número
		 */
		System.out.println("Representación decimal: " + 34 );
		System.out.println("Representación hexadecimal: " + 0x22 ); // 34
		System.out.println("Representación binaria: " + 0b0010_0010 ); // 34
		System.out.println("Representación octal: " + 042 ); // 34
		
		//===============Objeto String =====================================
		/*
		 * Tipo de dato String
		 * Es un objeto que se define con comillas dobles.
		 * 
		 * Si deseas imprimir comillas dobles,se usa el 
		 * caracter de escape \
		 *   \b backspace
		 *   \t tab
		 *   \n line feed
		 *   \r carriage return
		 *   \" double quote
		 *   \' single quote
		 *   \\ backslash
		 */
		String message = "Java \"monos\" a comer";
		System.out.println( message );
		
		/*
		 *  01010100 01101000 01100101 00100000 011101000110100101101101011001010010000001101101011000010110001101101000011010010110111001100101001000000110100101110011001000000110000100100000011000110110111101101110011100110111010101101100011001010010000001100110011100100110111101101101001000000110010101100001011100100110110001101001011001010111001000101110
		 *     T        h         e    (espacio)
		 * 
		 */
	}

}
