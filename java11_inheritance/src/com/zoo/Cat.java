package com.zoo;

public class Cat extends Feline {
	private String name;
	private boolean isDomestic;
	
	public Cat(String name, double age, boolean isDomestic) {
		super(age);
		this.name = name;
		this.isDomestic = isDomestic;
		super.setCommonName("Cat");
		super.setScientificName("Catus");
	}

	@Override
	public String noise() {
		return "Rauuuullll";
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final boolean isDomestic() {
		return isDomestic;
	}

	public final void setDomestic(boolean isDomestic) {
		this.isDomestic = isDomestic;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Cat [name=");
		builder.append(name);
		builder.append(", isDomestic=");
		builder.append(isDomestic);
		builder.append("]");
		return builder.toString();
	}

		
}
