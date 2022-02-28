package jugador.clases;

import java.util.ArrayList;

import construcciones.clases.Construccion;
import planetasyrecursos.Planeta;

public class Jugador {
	
	private static final int ORO_INICIAL = 5;
	
	private String nombre;
	private int oro;
	private ArrayList<Planeta> planetasEnPosesion;
	private ArrayList<Construccion> mazoConstrucciones;
	private boolean eliminado;
	
	
	public Jugador(String nombre) {
		this.planetasEnPosesion = new ArrayList<Planeta>();
		this.mazoConstrucciones = new ArrayList<Construccion>();
		this.oro = ORO_INICIAL;
		this.nombre = nombre;
	}
	
	
	public int getOro() {
		return oro;
	}
	
	public void setOro(int oro) {
		this.oro = oro;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Planeta> getPlanetasEnPosesion() {
		return planetasEnPosesion;
	}
	
	public ArrayList<Construccion> getMazoConstrucciones() {
		return mazoConstrucciones;
	}
	
	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public void modificarPlanetasEnPosesion(int indice, Planeta planeta){
		
		this.planetasEnPosesion.set(indice, planeta);
		
	}
	
	
}
