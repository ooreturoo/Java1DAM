package planetasyrecursos;

import java.util.Arrays;
import java.util.Objects;

import construcciones.clases.EscudoProtector;
import construcciones.clases.Mina;
import general.interfaces.IAtacable;
import naves.clases.Nave;
import recursos.clases.Materia;
import recursos.clases.MateriaPrima;
import utiles.TextosConsola;

public class Planeta implements IAtacable {
	
	private final int CANTIDAD_DE_MINAS = 10;
	private final int VIDA_ESCUDO_BASE = 100;
	private final int MAXIMO_NAVES_ORBITA = 40; 
	private final int HABITANTES_BASE = 30;
	
	private Planetas nombrePlaneta;
	private boolean conquistado;
	private String nombreConquistador;
	private MateriaPrima[] materiasPrimas;
	private int numeroHabitantes;
	private Mina[] minas;
	private boolean escudoProtector;
	private EscudoProtector escudo;
	private int cantidadEscudo;
	private Nave[] naves;
	
	public Planeta(Planetas nombrePlaneta) {
		this.nombrePlaneta = nombrePlaneta;
		this.materiasPrimas = new MateriaPrima[]{new MateriaPrima(5, Materia.PIEDRA),
							new MateriaPrima(4, Materia.HIERRO),new MateriaPrima(2, Materia.COMBUSTIBLE)};
		this.numeroHabitantes = HABITANTES_BASE;
		this.cantidadEscudo = VIDA_ESCUDO_BASE;
		this.minas = new Mina[CANTIDAD_DE_MINAS];
		this.naves = new Nave[MAXIMO_NAVES_ORBITA];
	}
	
	
	@Override
	public void serAtacado(int dañoRecibido) {
		if(this.cantidadEscudo < dañoRecibido) {
			this.cantidadEscudo = 0;
		}else {
			this.cantidadEscudo -= dañoRecibido;
		}
		
	}
	
	public void añadirNave(int indice, Nave nave) {
		this.naves[indice] = nave;
	}
	
	public void destruirNave(int indice) {
		this.naves[indice] = null;
		System.out.println(TextosConsola.NAVE_DESTRUIDA);
	}
	
	public void añadirMina(int indice, Mina mina) {
		minas[indice] = mina;
		System.out.println(TextosConsola.MINA_CONSTRUIDA);
	}
	
	public void destruirMina(int indice) {
		minas[indice] = null;
	}
	
	public void añadirEscudoProtector(EscudoProtector escudo) {
		this.escudo = escudo;
		System.out.println(TextosConsola.ESCUDO_PROTECTOR_CONSTRUIDO);
	}
	
	public void destruirEscudoProtector() {
		this.escudoProtector = false;
		this.escudo = null;
		System.out.println(TextosConsola.ESCUDO_PROTECTOR_DESTRUIDO);
	}
	
	public boolean isConquistado() {
		return conquistado;
	}

	public void setConquistado(boolean conquistado) {
		this.conquistado = conquistado;
	}

	public String getNombreConquistador() {
		return nombreConquistador;
	}

	public void setNombreConquistador(String nombreConquistador) {
		this.nombreConquistador = nombreConquistador;
	}

	public MateriaPrima[] getMateriasPrimas() {
		return materiasPrimas;
	}

	public void setMateriasPrimas(MateriaPrima[] materiasPrimas) {
		this.materiasPrimas = materiasPrimas;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public Planetas getNombrePlaneta() {
		return nombrePlaneta;
	}

	public Mina[] getMinas() {
		return minas;
	}

	public boolean isEscudoProtector() {
		return escudoProtector;
	}

	public int getCantidadEscudo() {
		return cantidadEscudo;
	}

	public void setCantidadEscudo(int cantidadEscudo) {
		this.cantidadEscudo = cantidadEscudo;
	}
	
	public Nave[] getNaves() {
		return naves;
	}

	public EscudoProtector getEscudo() {
		return escudo;
	}


	public void setEscudo(EscudoProtector escudo) {
		this.escudo = escudo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(materiasPrimas);
		result = prime * result + Arrays.hashCode(minas);
		result = prime * result + Objects.hash(cantidadEscudo, conquistado, escudoProtector, nombreConquistador,
				nombrePlaneta, numeroHabitantes);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planeta other = (Planeta) obj;
		return cantidadEscudo == other.cantidadEscudo && conquistado == other.conquistado
				&& escudoProtector == other.escudoProtector && Arrays.equals(materiasPrimas, other.materiasPrimas)
				&& Arrays.equals(minas, other.minas) && Objects.equals(nombreConquistador, other.nombreConquistador)
				&& Objects.equals(nombrePlaneta, other.nombrePlaneta) && numeroHabitantes == other.numeroHabitantes;
	}

	

	
	
}
