package naves.clases;

import naves.interfaces.ITransportador;
import planetasyrecursos.Planeta;
import recursos.clases.MateriaPrima;

public class NaveCarga extends Nave implements ITransportador {

	private static final int PUNTOS_DE_DEFENSA = 4;
	private int capacidadCarga;
	
	public NaveCarga(int capacidadCarga, Planeta planetaOrbitado, String nombrePropietario) {
		
		super(PUNTOS_DE_DEFENSA, planetaOrbitado, nombrePropietario);
		this.capacidadCarga = capacidadCarga;
		
	}
	
	//Modificar, tranportar el máximo permitido.
	@Override
	public void transportar(Planeta planetaDestino, MateriaPrima[] materiasPrimas) {
		
		MateriaPrima[] materiasPlaneta = planetaDestino.getMateriasPrimas();
		
		for(int i = 0; i < materiasPlaneta.length; i++) {
			MateriaPrima materiaPlaneta = materiasPlaneta[i];
			for(int j = 0; j < materiasPrimas.length; j++) {
				MateriaPrima materiaPrima = materiasPrimas[j];
				if(materiaPrima.getTipoMateria().equals(materiaPrima.getTipoMateria())) {
					materiaPlaneta.setCantidadMateria(materiaPrima.getCantidadMateria());
				}
			}
		}
		
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	
	
}
