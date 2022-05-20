package clases;


import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import Leer.Leer;

public class Resturante {

	private LinkedList<Receta> platosEnCarta;
	private Cocina cocina;
	
	public Resturante() {
		
		platosEnCarta = new LinkedList<Receta>();
		cocina = new Cocina();
		
	}
	
	
	public void buscarYMostrarReceta(String nombreReceta) throws RecetaException {
		
		Receta receta = buscarReceta(nombreReceta);
		
		Collections.sort(receta.getIngredientesNecesarios());
		System.out.println(receta);
		
	}
	
	public void buscarYMostrarReceta(String nombreReceta, Comparator<Ingrediente> comparador) throws RecetaException {
		
		Receta receta = buscarReceta(nombreReceta);
		
		receta.getIngredientesNecesarios().sort(comparador);
		System.out.println(receta);
		
	}
	
	private Receta buscarReceta(String nombreReceta) throws RecetaException {
		Receta receta = null;
		Iterator<Receta> iterador = platosEnCarta.iterator();
		
		while (iterador.hasNext() && receta == null){

			Receta recetaActual = iterador.next();
			
			if(nombreReceta.equals(recetaActual.getNombre())) {
				
				receta = recetaActual;
				
			}
			
		}
		
		if(receta == null) {
			
			throw new RecetaException("No hay ninguna receta con este nombre.");
			
		}
		
		return receta;
		
	}
	
	public List<Receta> recetasPosiblesCocinar(){
		
		List<Receta> recetasPosibles = platosEnCarta.stream()
												.filter( receta -> getCocina().comprobarPosibilidadCocinarReceta(receta))
												.collect(Collectors.toList());
		
		return recetasPosibles;
		
	}
	
	public void comparIngrediente() {
		
		String nombreIngrediente = Leer.lecturaString("Introduce el nombre del ingrediente que quieres comprar.");
		int cantidad = Leer.lecturaInt("¿Que cantidad de " + nombreIngrediente + " quieres comprar?", 0, true);
	
		Iterator<Ingrediente> iterador = cocina.getDespensa().iterator();
		
		while(iterador.hasNext()) {
			
			Ingrediente ing = iterador.next();
			
			if(ing.getNombre().equals(nombreIngrediente)) {
				
				cantidad += ing.getCantidad();
				iterador.remove();
				
			}
			
			cocina.getDespensa().add(new Ingrediente(nombreIngrediente, cantidad));
			
		}
		
	}
	
	
	public void agregarReceta() {
		
		String nombreReceta = Leer.lecturaString("Introduce el nombre de la receta.");
		int tiempoReceta = Leer.lecturaInt("Introduce el tiempo para la receta" , 1 , true);
		
		Receta receta =  new Receta(nombreReceta, tiempoReceta);
		
		agregarIngredientesReceta(receta);
		
		agregarPasosReceta(receta);
		
		platosEnCarta.add(receta);
		
	}
	
	private void agregarIngredientesReceta(Receta receta) {
		
		boolean continuar = true;
		
		while(continuar) {

			String ingrediente = Leer.lecturaString("Introduce un ingrediente necesario para la receta.");
			int cantidad = Leer.lecturaInt("Introduce la cantidad de " + ingrediente + " necesarios.");
			receta.getIngredientesNecesarios().add(new Ingrediente(ingrediente, cantidad));
			boolean respuestaValida = false; 
			String masIngredientes = Leer.lecturaString("¿Quieres introducir otro ingrediente?(SI - NO)");
			while (!respuestaValida) {
				if(masIngredientes.toUpperCase().trim().equals("SI")) {
					
					respuestaValida = true;
					
				}else if(masIngredientes.toUpperCase().trim().equals("NO")) {
					
					respuestaValida = true;
					continuar = false;
					
				}else {
					
					System.out.println("Contestación no valida.");
					
				}
				
			}
		}
		
	}
	
	private void agregarPasosReceta(Receta receta) {
		
		boolean continuar = true;
		int contador = 1;
		
		while(continuar) {

			String procedimiento = Leer.lecturaString("Introduce el paso " + contador +" para la receta.");
			receta.getProcedimientos().add(procedimiento);
			boolean respuestaValida = false; 
			String masIngredientes = Leer.lecturaString("¿Quieres introducir otro paso?(SI - NO)");
			while (!respuestaValida) {
				if(masIngredientes.toUpperCase().trim().equals("SI")) {
					
					respuestaValida = true;
					
				}else if(masIngredientes.toUpperCase().trim().equals("NO")) {
					
					respuestaValida = true;
					continuar = false;
					
				}else {
					
					System.out.println("Contestación no valida.");
					
				}
				
			}
			contador ++;
			
		}
		
	}

	public LinkedList<Receta> getPlatosEnCarta() {
		return platosEnCarta;
	}

	public Cocina getCocina() {
		return cocina;
	}
	
	
	
}
