package clases;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import Leer.Leer;

public class Receta {

	private String nombre;
	private int minDuracion;
	private LinkedList<String> procedimientos;
	private LinkedList<Ingrediente> ingredientesNecesarios;
	
	public Receta(String nombre, int minDuración) {
		
		this.nombre = nombre;
		this.minDuracion = minDuración;
		this.procedimientos = new LinkedList<String>();
		this.ingredientesNecesarios = new LinkedList<Ingrediente>();
		
	}
	
	public void ordenarIngredientesPorCantidad() {
		
		ingredientesNecesarios.sort(new Comparator<Ingrediente>() {

			@Override
			public int compare(Ingrediente o1, Ingrediente o2) {
				return o2.getCantidad() - o1.getCantidad();
			}
		}
		);
		
	}
	
	public void borrarProcedimientoReceta() {
		
		Iterator<String> iterador = procedimientos.iterator();
		
		while (iterador.hasNext()) {
			
			String procedimiento = iterador.next();
			
			System.out.println("Procedimiento: " + procedimiento);
			String desicion = Leer.lecturaString("¿Deseas borrar este procedimiento?").toUpperCase().trim();
			boolean desicionValida = false;
			
			
			while (!desicionValida) {

				if(desicion.equals("SI")) {
					
					iterador.remove();
					desicionValida = true;
					
				}else if (desicion.equals("NO")) {
					
					desicionValida = true;
					
				}else {
					
					System.out.println("Valor no válido");
					
				}
				
			}
			
			
			
		}
		
	}
	
	public void agregarIngrediente(Ingrediente ingrediente) {
		
		ingredientesNecesarios.add(ingrediente);
		Collections.sort(ingredientesNecesarios);
		
	}
	

	
	@Override
	public String toString() {
		return "Receta [nombre=" + nombre + ", minDuracion=" + minDuracion + ", procedimientos=" + procedimientos
				+ ", ingredientesNecesarios=" + ingredientesNecesarios + "]";
	}

	public int getMinDuracion() {
		return minDuracion;
	}

	public void setMinDuracion(int minDuracion) {
		this.minDuracion = minDuracion;
	}

	public String getNombre() {
		return nombre;
	}

	public LinkedList<String> getProcedimientos() {
		return procedimientos;
	}

	public LinkedList<Ingrediente> getIngredientesNecesarios() {
		return ingredientesNecesarios;
	}
	
	
	
}
