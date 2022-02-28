package construcciones.clases;

import java.util.Objects;

import recursos.clases.Materia;
import recursos.clases.MateriaPrima;

public class Mina extends Construccion{

	public static final int PERSONAS_NECESARIAS = 10;
	public static final MateriaPrima[] COSTES_CONSTRUCCION = {
			new MateriaPrima(2, Materia.PIEDRA), new MateriaPrima(2, Materia.HIERRO), new MateriaPrima(1, Materia.COMBUSTIBLE)
			};
	
	private Materia materialMinable;
	private int cantidadMinable;
	
	public Mina(Materia materialMinable, int cantidadMinable) {
		super(PERSONAS_NECESARIAS, COSTES_CONSTRUCCION);
		this.materialMinable = materialMinable;
		this.cantidadMinable = cantidadMinable;
	}
	
	public Materia getMaterialMinable() {
		return materialMinable;
	}

	public int getCantidadMinable() {
		return cantidadMinable;
	}
	
	@Override
	public String toString() {
		return "Mina. Material: " + materialMinable + ". Minado por turno: " + cantidadMinable + ".";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadMinable, materialMinable);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mina other = (Mina) obj;
		return cantidadMinable == other.cantidadMinable && materialMinable == other.materialMinable;
	}
	
	
	
	
}
