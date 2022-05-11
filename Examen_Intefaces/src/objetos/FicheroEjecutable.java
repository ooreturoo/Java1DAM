package objetos;

import java.time.LocalDate;

import interfaces.Analizable;


public class FicheroEjecutable extends FicheroBinario implements Analizable{

	private int permisos;
	
	public FicheroEjecutable(String nombre, LocalDate fechaCreacion,
			int dimensionesContenido, int premisos) {
		
		super(nombre,  fechaCreacion, dimensionesContenido);
		
		this.permisos = premisos;
		
	}
	
	public FicheroEjecutable(String nombre, int premisos, int dimensionesContenido) {
		
		super(nombre, dimensionesContenido);
		
		this.permisos = premisos;
		
	}

	public int getPermisos() {
		return permisos;
	}

	public void setPermisos(int permisos) {
		this.permisos = permisos;
	}

	@Override
	public void analizar() {
		
		System.out.println("Analizando " + getNombre());
		
	}

}
