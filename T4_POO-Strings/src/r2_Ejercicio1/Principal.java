package r2_Ejercicio1;

import java.time.LocalDate;

public class Principal {
	public static void main(String[] args) {
		Persona persona = new Persona("Sergio", LocalDate.of(1997, 9, 18), 7608781, 'm');
		persona.setAltura(1.89f);
		persona.setPeso(82.9f);
		System.out.println(persona.getIMC());
		System.out.println(persona);
	}
}
