package mx.gob.loterianacional;

import java.util.Arrays;
import java.util.Random;

public class Melate {
	
	/**
	 * Genera un número aleatorio entre 1 y 54 (inclusive).
	 * @return número entero.
	 */
	int numeroAleatorio(int min, int max) {
		Random random = new Random();
		return random.nextInt(min, max + 1);
	}
	
	int randomNumber(int min, int max) {
	    // Generar un número aleatorio entre 0.0 y 1.0(sin incluir)
	    double randomValue = Math.random();
	    // Escalar el número aleatorio al rango deseado
	    double scaledRandomValue = randomValue * (max - min + 1);
	    // Convertir el número escalado en un entero redondeado hacia arriba
	    int finalNumber = (int) Math.ceil(scaledRandomValue);
	    return finalNumber;
	}
	
	
	
	/**
	 * Muestra en consola 7 números aleatorios del 1 al 54.
	 * Refactorizar el método para que genere 7 números aleatorios
	 * sin repetir.
	 */
	void printRandomNumbersList (int number, int min, int max) {
		int[] num = new int [number];
		for (int i = 0; i < number ; i++) {
			num[i] = numeroAleatorio(min, max);
		}
		System.out.println("tu lista de numeros es :"+ Arrays.toString(num));
	}
	
	/**
	 * Sobrecarga 
	 * El polimorfismo en tiempo de compilación en Java 
	 * se conoce como sobrecarga de métodos (Method Overloading). 
	 * Ocurre cuando múltiples métodos en una misma clase 
	 * tienen el mismo nombre pero diferentes firmas 
	 * (diferente número o tipo de parámetros).
	 */
	boolean printRandomNumbersList(String numero, String minimo, String maximo){
		int number = Integer.parseInt(numero);
		int min = Integer.parseInt(minimo);
		int max = Integer.parseInt(maximo);
		printRandomNumbersList(number, min, max);
		return true;
	}
	
	/**
	 * Sobrecarga de método que imprime en consola 7 números aleatorios del
	 * 1 al 100.
	 */
	void printRandomNumbersList() {
	    printRandomNumbersList(7, 1, 100);
	}

}
