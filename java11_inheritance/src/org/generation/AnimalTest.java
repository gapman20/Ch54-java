package org.generation;

import com.roles.EsquemaDeVacunacion;
import com.roles.Pet;
import com.zoo.Animal;
import com.zoo.Cat;
import com.zoo.Leopardo;

public class AnimalTest {

	public static void main(String[] args) {
		
		// new Animal(); No se puede intanciar por ser una clase abstracta
		// new Feline(); No se puede intanciar por ser una clase abstracta
		   Animal myPet  = new Cat("Judi", 0.2, true );
		// myPet = new Leopardo ("Raul", "Male", true, 5);

		
		System.out.println( myPet ); // Cat, Catus, 0.2, Judi, true
		System.out.println( myPet.noise() ); // Rauul
		
		if( myPet instanceof Cat ) {
			Cat myCat = (Cat)myPet;
			System.out.println("Es doméstico : " +  myCat.isDomestic());
		} else if( myPet instanceof Leopardo) {
			Leopardo myLeopard = (Leopardo)myPet;
			System.out.println("Es salvaje: " + myLeopard.isWild() );
		}
		else {
			System.out.println("Este animal no conoce ese atributo");
		}
		
		// Realizar el truco si el objeto implementa la interfaz Pet
		if( myPet instanceof Pet) {
			Pet pet = (Pet)myPet;
			System.out.println("Mi truco es:" + pet.trick() );
		}
		
		// Se vacuna al animal?
		if( myPet instanceof EsquemaDeVacunacion) {
			EsquemaDeVacunacion animalAVacuna = (EsquemaDeVacunacion)myPet;
			System.out.println( "Se vacuna: " + animalAVacuna.aplicarVacuna(100) );
		} else {
			System.out.println("Este animal no se vacuna");
		}
			

	}

}
