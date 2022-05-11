package paqute;

import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		
		ListaOrdenada<Integer> lista = new ListaOrdenada<>();
		
		lista.addOrdenado(1);
		lista.addOrdenado(5);
		lista.addOrdenado(3);
		lista.addOrdenado(8);
		lista.addOrdenado(6);
		
		for(Integer i : lista.getLista()) {
			
			System.out.println(i);
			
		}
		
	}
	
}
