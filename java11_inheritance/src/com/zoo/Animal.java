package com.zoo;


/**
 *  Las clases abstractas son clases que no se pueden instanciar.
 *  Estas clases se utilizan como modelos(plantillas) para
 *  crear subclases concretas que se puedan instanciar.
 *  
 *  una clase abstracta se declara en la firma de la clase
 *  con la palabra reservada "abstract"
 *  
 *  La clase abstracta puede contener métodos abstractos y
 *  métodos concretos.
 *  
 *  Los métodos abstractos no tienen implementación. La implementación
 *  se debe realizar en las subclases concretas.
 *  
 *  Las clases abstractas se recomienda utilizar para
 *  clases que estén estrechamente relacionadas ( is-A )
 */
abstract public class Animal {
	
	private String commonName;
	private String scientificName;
	private double age;
	
	public Animal(String commonName, String scientificName, double age) {
		this.commonName = commonName;
		this.scientificName = scientificName;
		this.age = age;
	}
	
	/**
	 *  Un método abstracto no tiene implementación, solo
	 *  la definción del método.
	 *  Termina con punto y coma.
	 *  
	 *  Si tienes un método abstracto, tienes la obligación
	 *  de hacer tu clase abstracta.
	 */
	abstract public String noise();
	abstract public String nervousSystem();

	public final String getCommonName() {
		return commonName;
	}

	public final void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public final String getScientificName() {
		return scientificName;
	}

	public final void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public final double getAge() {
		return age;
	}

	public final void setAge(double age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [commonName=");
		builder.append(commonName);
		builder.append(", scientificName=");
		builder.append(scientificName);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	

}
