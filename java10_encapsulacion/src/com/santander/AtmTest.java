package com.santander;

public class AtmTest {

	public static void main(String[] args) {
		Atm cajero01 = new Atm();
		cajero01.setSerialNumber(1);
		cajero01.setBalance(500_000);
		cajero01.setModel("T-800");
		cajero01.setAddress("Av. siempre viva");
		
		Atm cajero02 = new Atm(2, 400_00, "T-1000", "Av. Concha 8254");
		Atm cajero03 = new Atm();
		Atm cajero04 = new Atm(100_000);
		Atm cajero05 = Atm.createAirPortAtm();
		
		System.out.println( cajero01 );
		System.out.println( cajero02 );
		System.out.println( cajero03 );
		System.out.println( cajero04 );
		System.out.println( cajero05 );

	}

}
