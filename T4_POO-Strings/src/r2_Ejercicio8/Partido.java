package r2_Ejercicio8;

import Leer.Leer;

public class Partido {
	private Equipos equipoLocal;
	private Equipos equipoVisistante;
	private int golesLocal;
	private int golesVisitante;
	private static int partidoJornada;
	private char resultado;
	
	private Partido(Equipos equipoLocal, Equipos equipoVisitante) {
		this.equipoLocal = equipoLocal;
		this.equipoVisistante = equipoVisitante;
	}
	
	
	public static Partido crearPartido() {
		boolean equiposValidos = false;
		Equipos equipoLocal = null;
		Equipos equipoVisitante = null;
		while(!equiposValidos) {
			equipoLocal = Equipos.crearEquipos("local");
			equipoVisitante = Equipos.crearEquipos("visitante");
			if(!equipoLocal.getNombre().equals(equipoVisitante.getNombre())) {
				if(partidoJornada <= 38) {
					partidoJornada++;
				}else {
					partidoJornada = 0;
					System.out.println("La jornada ya terminó, el partido formara parte de la siguiente jornada");
				}
				equiposValidos = true;
			}else {
				System.out.println("No se ha podido crear el partido, los equipos no pueden tener el mismo nombre");
			}
		}
		return new Partido(equipoLocal,equipoVisitante);
		
	}
	
	
	
	public void ponerResultado() {
		int golesLocal = Leer.lecturaInt("Introduce los goles del equipo local.", 0, true);
		int golesVisitante = Leer.lecturaInt("Introduce los goles del equipo visitante.", 0, true);
		
		if(golesLocal > golesVisitante) {
			this.resultado = '1';
		}else if(golesLocal == golesVisitante) {
			this.resultado = 'X';
		}else {
			this.resultado = '2';
		}
		
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}
	
	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		
		if(this.resultado != '1' && this.resultado != 'X' && this.resultado != '2') {
			bf.append("Partido entre equipo local ");
			bf.append(this.equipoLocal.getNombre());
			bf.append(" y equipo visitante ");
			bf.append(this.equipoVisistante.getNombre());
			bf.append(" todavía no se ha jugado");
		}else {
			bf.append("Partido entre equipo local ");
			bf.append(this.equipoLocal.getNombre());
			bf.append(" y equipo visitante ");
			bf.append(this.equipoVisistante.getNombre());
			bf.append(" jugado en el estadio ");
			bf.append(this.equipoLocal.getEstadio());
			bf.append(" de la ciudad ");
			bf.append(this.equipoLocal.getCiudad());
			bf.append(",\nha finalizado con ");
			bf.append(this.golesLocal);
			bf.append(" goles del equipo local y ");
			bf.append(this.golesVisitante);
			bf.append(" goles del equipo visitante.");
			bf.append("\n Resultado de la quiniela= ");
			bf.append(this.resultado);
		}
		return bf.toString();
	}
}
