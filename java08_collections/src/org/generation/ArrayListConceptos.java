package org.generation;

import java.util.ArrayList;

public class ArrayListConceptos {

	public static void main(String[] args) {
		/*
		 * Una colección, parte del Java Collections Framework, es 
		 * un objeto que agrupa múltiples elementos en una sola unidad. 
		 * Su principal ventaja es que su tamaño es dinámico, puede 
		 * crecer o reducirse según sea necesario.
		 * 
		 * Existen varios tipos, los más comunes son: 
		 * List: Una secuencia ordenada de elementos. 
		 *       Permite duplicados. (Ej: ArrayList)
		 * Set: Un conjunto de elementos únicos. 
		 *       No permite duplicados. (Ej: HashSet)
		 * Map: Un conjunto de pares clave-valor. 
		 *       Las claves deben ser únicas. (Ej: HashMap)
		 * 
		 * Array List.
		 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
		 * 
		 * Una colección List 
		 * - Es una colección ordenada (respeta
		 * el orden en que se agregan) 
		 * - Se permite elementos duplicados 
		 * - Se basa en un array redimensionable que crece su tamaño, según crece la colección de
		 * elementos. 
		 * - Esta colección es la mejor rendimiento tiene.
		 * 
		 * Sintaxis: ArrayList<object> varName = new ArrayList<>();
		 * 
		 * 
		 */
		
		// Definir una colección de datos numéricos
		// ArrayList< int > numeros; Se debe indicar una clase(wrapper para los primitivos)
		ArrayList< Integer > numeros;
		numeros = new ArrayList<Integer>();
		
		// Definir una colección para almacenar nombres de marcas de automóviles
		// Asignar el objeto de la colección a una variable
		 ArrayList <String> marcas = new ArrayList<>();
		 
		// Agregar un elemento con el método add() 
		 marcas.add("Toyota");
		// Agregar 3 marcas de automóviles
		 marcas.add("Tesla");
		 marcas.add("BYD");
		 marcas.add("Ford");
		 
		// Agregar un elemento que ya exista (duplicado)
		 marcas.add("Toyota");
		 
		 System.out.println( marcas );
		 
		 // Obtener el tamaño de mi colección, size()
		 System.out.println("Num. de autos: " + marcas.size() );
		 
		 // Devolver un elemento en una posición especificada, get( int indice)
		 System.out.println("A Cris medio le gusta el auto " + marcas.get(3));
		 
		 // Remover un elemento, remove(int indice), remove( objet )
		 System.out.println("Alexandra elimina " + marcas.remove(0) ); // toyota
		 System.out.println( marcas );
		 
		 // Reemplazar un elemento, set(int indice, E element)
		 System.out.println("Reemplazamos el índice 0: " + marcas.set(0, "WV") );
		 System.out.println( marcas );
		 
		 // Verificar si un elemento existe, contains()
		 System.out.println("Existe Chevrolet: " + marcas.contains("Chevrolet"));
		 System.out.println("Existe BYD: " + marcas.contains("BYD"));
		 
		// Iterar cada uno de los elementos usando for loop
		for (int i = 0; i < marcas.size(); i++) {
			System.out.println("los autos son " + marcas.get(i));
		}

		// iterar cada uno de los elementos usadno for enhanced
		for (String autos : marcas) {
			System.out.println("el carro es: " + autos);
		}
		
		/*
		 *  Aplicaciones:
		 *   - Carrito de compras
		 *   - Lista de películas
		 *   - Playlist
		 * 
		 */
		
	}

}
