package aa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prueba {

	public static void main(String[] args) {
		
//		List<Integer> lista = new ArrayList<Integer>();
//		
//		lista.add(3);
//		lista.add(15);
//		lista.add(21);
//		
//		String allMatch = lista.size() == lista.stream().filter((n) -> n%3 == 0).count() ? "si" : "no";
//		
//		
//		String noneMatch =lista.stream().filter((n) -> n%2 != 0).count() == 0 ? "si" : "no";
//		
//		String anyMatch = lista.stream().filter((n) -> n > 20).count() > 0 ? "si" : "no";
//		
//		
//		System.out.println("AllMatch: " + allMatch);
//		System.out.println("AnyMatch: " + anyMatch);
//		System.out.println("NoneMatch: " + noneMatch);
		
		
		
		Persona p1 = new Persona("Pepe", 25, 182, new Coche("BMW",100));
		Persona p2 = new Persona("Juan", 25, 165, new Coche("Opel",45));
		Persona p3 = new Persona("María", 25, 168, new Coche("Ferrari",200));
		
		List<Persona> lista = new ArrayList<Persona>();
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		ArrayList<Coche> listaCoche =(ArrayList<Coche>) lista.stream().map((p) -> p.getCoche()).filter( c -> c.getCaballos() < 50).collect(Collectors.toList());
		
		
	}
	
}
