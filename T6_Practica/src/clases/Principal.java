package clases;


public class Principal {

	public static void main(String[] args) {
		
		Resturante rest = new Resturante();
		
		Receta receta1 = new Receta("Receta 1", 54);
		
		receta1.getIngredientesNecesarios().add(new Ingrediente("Zanahoria", 5));
		receta1.getIngredientesNecesarios().add(new Ingrediente("Fresa", 3));
		receta1.getIngredientesNecesarios().add(new Ingrediente("Remolacha", 2));
		receta1.getIngredientesNecesarios().add(new Ingrediente("Tomate", 5));
		
		rest.getPlatosEnCarta().add(receta1);
		
		rest.getCocina().getDespensa().add(new Ingrediente("Zanahoria", 5));
		rest.getCocina().getDespensa().add(new Ingrediente("Fresa", 3));
		rest.getCocina().getDespensa().add(new Ingrediente("Remolacha", 2));
		rest.getCocina().getDespensa().add(new Ingrediente("Tomate", 3));
		
		boolean cocinable =rest.getCocina().comprobarPosibilidadCocinarReceta(receta1);
	
		rest.comparIngrediente();
		
		rest.getCocina().getDespensa().forEach(System.out::println);
		
		rest.comparIngrediente();
		
		rest.getCocina().getDespensa().forEach(System.out::println);
		
	}
	
}
