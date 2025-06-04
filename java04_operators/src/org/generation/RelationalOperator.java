package org.generation;

public class RelationalOperator {

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
	       System.out.println("value1 != value2"); // Se imrpime
	     
	     if(value1 > value2) // false
	       System.out.println("value1 > value2"); // no se imprime
	     
	     if(value1 < value2) // true
	       System.out.println("value1 < value2"); // se imprime
	     
	     if(value1 <= value2) // true
	       System.out.println("value1 <= value2"); // se imprime

	     
	}

}
