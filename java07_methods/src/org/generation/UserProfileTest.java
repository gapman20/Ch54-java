package org.generation;

public class UserProfileTest {

	public static void main(String[] args) {
		
		UserProfile userProfile = new UserProfile();
		
		boolean isValid = userProfile.isValidEmail(null);
		System.out.println("El valor null es válido? " + isValid); // false
		
		isValid = userProfile.isValidEmail("myemail_gmail_com");
		System.out.println("El valor 'myemail_gmail_com' es válido? " + isValid); // false 
		
		isValid = userProfile.isValidEmail("myemail@gmail.com");
		System.out.println("El valor 'myemail@gmail.com' es válido? " + isValid); // true 

		//=======================================================
		String nameFormated = userProfile.nameFormatted("David");
		System.out.println("Nombre formateado: " + nameFormated); // david
		
		nameFormated = userProfile.nameFormatted("  Ch 54   ");
		System.out.println("Nombre formateado: " + nameFormated); // ch 54
		
		// ======================================================
		
		userProfile.logError("Tengo hambre y ya no estoy pensando");
		
	}

}
