package naves.clases;

import general.interfaces.IAtacable;
import planetasyrecursos.Planeta;

public abstract class Nave implements IAtacable {

	private int puntosDefensa;
	private Planeta planetaOrbitado;
	private String nombrePropietarioNave;
	
	public Nave(int puntosDeDefensa, Planeta planetaOrbitado, String nombrePropietarioNave) {
		this.puntosDefensa = puntosDeDefensa;
		this.planetaOrbitado = planetaOrbitado;
		this.nombrePropietarioNave = nombrePropietarioNave;
	}
	
	@Override
	public void serAtacado(int dañoRecibido) {
		
		if(puntosDefensa < dañoRecibido) {
			puntosDefensa = 0;
		}else {
			puntosDefensa -= dañoRecibido;
		}
		
	}

	public int getPuntosDefensa() {
		return puntosDefensa;
	}

	public void setPuntosDefensa(int puntosDefensa) {
		this.puntosDefensa = puntosDefensa;
	}

	public Planeta getPlanetaOrbitado() {
		return planetaOrbitado;
	}

	public String getNombrePropietarioNave() {
		return nombrePropietarioNave;
	}
	
	
	
	


	
	
}
