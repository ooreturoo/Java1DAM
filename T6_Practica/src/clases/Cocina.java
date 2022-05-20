package clases;



import java.util.HashSet;

public class Cocina {


	private HashSet<Ingrediente> despensa;
	
	public Cocina() {
		
		this.despensa = new HashSet<Ingrediente>();
		
	}

	public HashSet<Ingrediente> getDespensa() {
		
		return despensa;
		
	}
	
	public boolean comprobarPosibilidadCocinarReceta(Receta receta) {
		
		boolean cocinable = receta.getIngredientesNecesarios()
				.stream()
				.allMatch( ingN -> despensa.stream()
											.anyMatch( ingD -> ingD.equals(ingN) 
															&& ingD.getCantidad() >= ingN.getCantidad())); 
		
		return cocinable;
		
	}
	
	
}
