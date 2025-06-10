package org.generation;

public class ArrayConceptos {

	public static void main(String[] args) {
		/*
		 *  Las variables de tipo array se definen con corchetes []
		 *  Los corchetes pueden ir antes o después de la variable
		 *  ej. int[] myArray;
		 *      int myArray[];
		 *      Pantalon[] pantalones;
		 *  
		 *  Para los array se debe asignar la cantidad de elementos
		 *  que contendrá.
		 *  Una vez definido, el arreglo no púede cambiar su tamaño
		 * */
		
		// Definir un arreglo de 4 elementos de tipo int.
		int[] colorsCode = new int[4];
		int[] colorsCode2 = {0x0000, 0xFFFF, 0xBBBB, 0xABCD}; // definiendo e inicializando

		// Definir un arreglo de 4 elementos de tipo String.
		// para que contenga el nombre de frutas
		// String[] miFrutero = new String [4];
		String[] miFrutero = {"Manzana", "Fresa", "Durazno", "Sandia"};
		
		/*
		 * Uso de los arreglos: Ideal cuando sabes exactamente cuántos 
		 * elementos necesitas almacenar.
		 */
		
		// Aceder al elemento por su indice, los arreglos son índice cero
		String myFruit = miFrutero[1];
		System.out.println("Mi fruta preferida: " + myFruit);
		
		// Reemplazar un elemento
		// Reemplazar la sandia por rambután
		miFrutero[3] = "Rambután";
		System.out.println( miFrutero );
		
		for (int index = 0; index < miFrutero.length; index++) {
			System.out.println("La fruta de mi frutero: " + miFrutero[index] );
		}
		
		// for loop enhanced 
		for (String fruta : miFrutero) {
			System.out.println("El mercado venden: " + fruta);
		}
		
		// Acceder a un elemento que no exista
		// String myFavoriteFruit = miFrutero[10]; // ArrayIndexOutOfBoundsException
		
		
	}

}
