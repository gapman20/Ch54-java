package org.generation.app.service.impl;

import org.generation.app.service.PaymentTerminal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("bancomerTerminal")
@Primary
public class BancomerPaymentTerminal implements PaymentTerminal {

	private String name;
	private static String model;
	
	{ // Bloque de código de inicialización de atributos NO estáticos
		this.name = "Bancomer";
		System.out.println("Tengo vida, me llamo " + name);
	}
	
	public BancomerPaymentTerminal() {
	 // Constructor por default	
	}
	
	public BancomerPaymentTerminal(String name) {
	 // Constructor sobrecargado para inicializar name	
		this.name = name;
	}
	
	@Override
	public String charge(double amount) {
		return "Cobrando de BANCOMER la cantidad de "+ amount;
	}

}
