package r2_Ejercicio8;

import Leer.Leer;

public class Equipos {
	private String nombre;
	private String estadio;
	private String ciudad;
	private int partidosGanados;
	
	private Equipos(String nombre, String estadio, String ciudad) {
		this.nombre = nombre;
		this.estadio = estadio;
		this.ciudad = ciudad;
	}
	
	public static Equipos crearEquipos(String localVisitante) {
		return new Equipos(Leer.lecturaString("Introduce el nombre del equipo " + localVisitante +"."),Leer.lecturaString("Introduce el nombre de su estadio."),
				Leer.lecturaString("Introduce el nombre de su ciudad."));
	}
	

	public String getNombre() {
		return nombre;
	}

	public String getEstadio() {
		return estadio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
}
