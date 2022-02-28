package naves.clases;

import naves.interfaces.ITansportable;
import planetasyrecursos.Planeta;

public class NaveTransporte extends Nave implements ITansportable {
	
	private static final int PUNTOS_DE_DEFENSA = 4;
	private int capacidadTransporte;
	
	public NaveTransporte(int capacidadTransporte , Planeta planetaOrbitado, String nombrePropietario) {
		
		super(PUNTOS_DE_DEFENSA, planetaOrbitado, nombrePropietario);
		this.capacidadTransporte = capacidadTransporte;
		
	}

	@Override
	public void transportar(Planeta planetaDestino, int cantidadPersonas) {
		if(planetaDestino.getNumeroHabitantes() <= capacidadTransporte) {
			planetaDestino.setNumeroHabitantes(capacidadTransporte);
			
		}
		planetaDestino.setNumeroHabitantes(planetaDestino.getNumeroHabitantes()+cantidadPersonas);
		
	}

	public int getCapacidadTransporte() {
		return capacidadTransporte;
	}

	public void setCapacidadTransporte(int capacidadTransporte) {
		this.capacidadTransporte = capacidadTransporte;
	}
	
	
	
	
}
