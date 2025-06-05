package org.generation;

public class RelationalOperator {
	
	int id; // no static field ( atributo de instancia)
	        // El valor por default de los números es: 0
			// El valor por default de boolean es: false
	        // El valor por default de char es: \u0000'
	        // El valor por default de los obejetos es: null

	public static void main(String[] args) {
		/*
		 *  Operadores de igualdad, relacionales y condicionales
		   
		   ==      equal to
		   !=      not equal to
		   >       greater than
		   >=      greater than or equal to
		   <       less than
		   <=      less than or equal to		
		 
		 */
		 int value1 = 1;
	     int value2 = 2;
	        
	     if(value1 == value2 ) // false
	       System.out.println("value1 == value2"); // no se imprime
	     
	     if(value1 != value2) // true
	       System.out.println("value1 != value2"); // Se imprime
	     
	     if(value1 > value2) // false
	       System.out.println("value1 > value2"); // no se imprime
	     
	     if(value1 < value2) // true
	       System.out.println("value1 < value2"); // se imprime
	     
	     if(value1 <= value2) // true
	       System.out.println("value1 <= value2"); // se imprime
	     
	    
	     /**
	      *  Convertir un String a un número
	      *  La clase wrapper (o envoltorio) es una clase que 
	      *  encapsula un tipo primitivo en un objeto. Esto 
	      *  permite tratar los tipos primitivos (int, char, boolean, etc.)
	      *  como objetos
	      *  
	      *  Ventajas de los primitivos:
	      *   - Más rápidos en rendimiento.
	      *   - Menor consumo de memoria.
	      *   
	      *  Desventajas de los primitivos:
	      *   - No se puede usar en colecciones genéricas
	      *   - No poseen métodos ni atributos
	      *   - No pueder ser null
	      */
	     // if(value1 <= "10") No se puede realizar esta operación
	     String numberString = "10";

	     byte myValueByte = Byte.parseByte(numberString);
	     if( value1 <= myValueByte ) System.out.println("myValueByte es mayor");
	     /*
	      * Realizar la comparación de value1
	      * con una nueva variable que sea de tip short
	      * nota: se debe convertir numberString a un tipo short 
	      */
	     short myValueShort = Short.parseShort(numberString); 
		 if (value1 <= myValueShort) System.out.println("myValueShort es mayor");
	     /*
	      * Realizar la comparación de value1
	      * con una nueva variable que sea de tip double
	      * nota: se debe convertir numberString a un tipo double 
	      */
		 double myValueDouble = Double.parseDouble(numberString);
	     if (value1 <= myValueDouble) System.out.println("myValueDouble es mayor");
		 
	}

}
