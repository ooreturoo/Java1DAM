package naves.clases;

import general.interfaces.IAtacable;
import general.interfaces.IAtacador;
import planetasyrecursos.Planeta;

public class NaveAtaque extends Nave implements IAtacable, IAtacador{
	
	private static final int PUNTOS_DE_DEFENSA = 7;
	private static final int DAÑO_BASE = 3;
	private int dañoDeAtaque;
	
	public NaveAtaque(Planeta planetaOrbitado, String nombrePropietario) {
		super(PUNTOS_DE_DEFENSA, planetaOrbitado, nombrePropietario);
		this.dañoDeAtaque = DAÑO_BASE;
	}
	
	@Override
	public <T extends IAtacable> void Atacar(T objetivo) {
		
		objetivo.serAtacado(dañoDeAtaque);
		
	}
	
	

}
