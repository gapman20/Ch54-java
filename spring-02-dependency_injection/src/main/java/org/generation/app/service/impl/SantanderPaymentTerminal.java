package org.generation.app.service.impl;

import org.generation.app.service.PaymentTerminal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
 *  - Implementar la interfaz de PaymentTermina
 *  - Realizar la implementación de charge
 *  - Hacer la clase un Componente para que se genere un
 *    bean en el contenedor de inversión de control de String
 *  - Ya sea en el contructor por Default o usando un bloque
 *  de inicialización no-estatico enviar un mensaje a la consola
 *   "Tengo vida, me llamo Santander"
 */
@Component("santanderTerminal")
//@Primary
public class SantanderPaymentTerminal implements PaymentTerminal {
	
	private String name;
	
	{ 
		this.name = "Santander";
		System.out.println("Tengo vida, me llamo " + name);
	}
	

	@Override
	public String charge(double amount) {		
		return "Cobrando de Santander la cantidad " + amount;
	}

}
