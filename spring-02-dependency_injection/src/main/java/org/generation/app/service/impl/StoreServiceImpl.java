package org.generation.app.service.impl;

import org.generation.app.service.PaymentTerminal;
import org.generation.app.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //es una especialización de @Component. 
         //Indica que esta clase contiene lógica de negocio.
public class StoreServiceImpl implements StoreService {

	// @Autowired // Spring "inyectará" el bean directamente en este campo.
	// @Qualifier("bancomerTerminal")
	private PaymentTerminal mainTerminal;
	
	
	// Con @Qualifier, forzamos a Spring a inyectar el bean con ese nombre específico.
	public StoreServiceImpl(@Qualifier("bancomerTerminal") PaymentTerminal terminal){
		this.mainTerminal = terminal;
	}
	
	{System.out.println("Soy el Store Service y tengo vida");}
	
	@Override
	public void checkout(double amount) {
		System.out.println("= Hola, Bienvenid@ a nuestra tienda =");
		System.out.println("Le cobro el gansito");
		System.out.println(this.mainTerminal.charge(amount));	
	}

}
