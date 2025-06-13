package org.generation;

import com.zoo.Animal;
import com.zoo.Cat;

public class AnimalTest {

	public static void main(String[] args) {
		
		// new Animal(); No se puede intanciar por ser una clase abstracta
		// new Feline(); No se puede intanciar por ser una clase abstracta
		Animal myPet  = new Cat("Judi", 0.2, true );
		
		System.out.println( myPet ); // Cat, Catus, 0.2, Judi, true
		System.out.println( myPet.noise() ); // Rauul
		
		if( myPet instanceof Cat ) {
			Cat myCat = (Cat)myPet;
			System.out.println("Es doméstico : " +  myCat.isDomestic());
		} else {
			System.out.println("Este animal no conoce ese atributo");
		}
			

	}

}
