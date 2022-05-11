package clases;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cocina {

	private Resturante restaurantePertenece;
	private LinkedList<Ingrediente> despensa;
	
	public Cocina(Resturante restaurantePertenece) {
		
		this.restaurantePertenece = restaurantePertenece;
		this.despensa = new LinkedList<Ingrediente>();
		
	}

	public LinkedList<Ingrediente> getDespensa() {
		
		return despensa;
		
	}
	
	public boolean comprobarPosibilidadCocinarReceta(Receta receta) {
		
		boolean cocinable = receta.getIngredientesNecesarios()
				.stream()
				.allMatch( ingN -> despensa.stream()
											.anyMatch( ingD -> ingD.equals(ingN) 
															&& ingD.getCantidad() >= ingN.getCantidad())); 
		
		
		
//		Iterator<Ingrediente> iterador = receta.getIngredientesNecesarios().iterator();
//		boolean cocinable = true;
//		
//		while(iterador.hasNext() && cocinable) {
//			
//			boolean ingredienteEncontrado = false;
//			
//			Ingrediente ingReceta = iterador.next();
//			
//			Iterator<Ingrediente> iteradorDespensa = despensa.iterator();
//			
//			while (iteradorDespensa.hasNext() && !ingredienteEncontrado) {
//				
//				Ingrediente ingDespensa = iteradorDespensa.next();
//				
//				if(ingDespensa.equals(ingReceta) && ingDespensa.getCantidad() >= ingReceta.getCantidad()) {
//					
//					ingredienteEncontrado = true;
//					
//				}
//				
//			}
//			
//			cocinable = ingredienteEncontrado;
//			
//		}
		
		return cocinable;
		
	}

	public List<Receta> recetasPosiblesCocinar(){
		
		List<Receta> recetasPosibles =restaurantePertenece.getPlatosEnCarta().stream()
												.filter( receta -> comprobarPosibilidadCocinarReceta(receta))
												.collect(Collectors.toList());
		
		return recetasPosibles;
		
	}
	
	
}
