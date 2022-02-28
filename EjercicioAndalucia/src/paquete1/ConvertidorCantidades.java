package paquete1;

public class ConvertidorCantidades {

	public static int obtenerTabletas(int numeroOnzas) {
		int resto = numeroOnzas % Productos.TABLETACHOCOLATE.getOnzasChocolate();
		int cantidadTabletas = numeroOnzas / Productos.TABLETACHOCOLATE.getOnzasChocolate();
		if(resto != 0) {
			cantidadTabletas++;
		}
		
		return cantidadTabletas;
	}
	
	public static int litroAceite(int mililitrosAceites) {
		
		int resto = mililitrosAceites % 1000;
		int litros = mililitrosAceites / 1000;
		if(resto != 0) {
			litros++;
		}
		
		return litros;
		
	}
	
	
}
