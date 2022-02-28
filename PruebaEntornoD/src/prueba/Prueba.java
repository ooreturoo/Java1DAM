package prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class Prueba {

	@Test
	public void pruebaSuma() {
		//Llamar a un método de otra clase para probarlo.
		int resultado = Matematicas.suma(5,4);
		int esperado = 9;
		assertEquals(esperado, resultado);
	}
	
}
