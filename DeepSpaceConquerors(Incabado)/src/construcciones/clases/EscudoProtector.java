package construcciones.clases;

import general.interfaces.IAtacable;
import recursos.clases.Materia;
import recursos.clases.MateriaPrima;

public class EscudoProtector extends Construccion implements IAtacable{
	
	private static final int PUNTOS_DEFENSA_DEFECTO = 20;
	public static final int PERSONAS_NECESARIAS = 15;
	public static final MateriaPrima[] COSTES_CONSTRUCCION = {
			new MateriaPrima(5, Materia.PIEDRA), new MateriaPrima(4, Materia.HIERRO), new MateriaPrima(4, Materia.COMBUSTIBLE)
			};
	
	private int puntosDefensa;
	
	public EscudoProtector() {
		super(PERSONAS_NECESARIAS, COSTES_CONSTRUCCION);
		this.puntosDefensa = PUNTOS_DEFENSA_DEFECTO;
	}
	
	@Override
	public void serAtacado(int dañoRecibido) {
		if(this.puntosDefensa < dañoRecibido) {
			this.puntosDefensa = 0;
		}else {
			this.puntosDefensa -= dañoRecibido;			
		}
	}

	public int getPuntosDefensa() {
		return puntosDefensa;
	}

	public void setPuntosDefensa(int puntosDefensa) {
		this.puntosDefensa = puntosDefensa;
	}

	

	

	
}
