package ej_2;

import java.util.HashSet;
import java.util.Set;

public class Equipo<T>{

	private String nombreEquipo;
	private Set<T> miembrosEquipo;
	
	public Equipo(String nombreEquipo) {
		miembrosEquipo = new HashSet<T>();
		this.nombreEquipo = nombreEquipo;
	}

	
	public void añadirMiembroEquipo(T miembro) throws AlumnoException {
		
		if(buscarAlumno(miembro) != null) {
			
			throw new AlumnoException("El alumno ya existe en el equipo.");
			
		}
		
		this.miembrosEquipo.add(miembro);
		
	}
	
	public void eliminarMiembro(T miembro) throws AlumnoException {
		
		if(buscarAlumno(miembro) == null) {
			
			throw new AlumnoException("El alumno no pertenece al equipo.");
			
		}
		
		this.miembrosEquipo.remove(miembro);
		
	}
	
	public T buscarAlumno(T miembroBuscar) {
		
		T miembroEncontrado = null;
		
		for(T alumno : this.miembrosEquipo) {
			
			if(alumno.equals(miembroBuscar)) {
				miembroEncontrado = alumno;
			}
			
		}
		
		return miembroEncontrado;
		
	}
	
	public void mostrarEquipo() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Miembros del equipo :").append("\n");
		this.miembrosEquipo.forEach(miembro -> sb.append(miembro).append("\n"));
		
		System.out.println(sb);
	}
	
	public Equipo<T> unirEquipos(Equipo<T> equipo) throws EquipoException {
		
		Equipo<T> nuevoEquipo = null;
		if(equipo != null) {
			
			nuevoEquipo = new Equipo<T>("Fusión-" + this.nombreEquipo + equipo.nombreEquipo);
			nuevoEquipo.miembrosEquipo.addAll(this.miembrosEquipo);
			
			if(equipo.miembrosEquipo.isEmpty()) {
				
				throw new EquipoException("El equipo no tiene ningún miembro.");
				
			}
			
			for(T elemento : equipo.miembrosEquipo) {
				
				if(!this.miembrosEquipo.contains(elemento)) {
					
					nuevoEquipo.miembrosEquipo.add(elemento);
					
				}
				
			}
			
		}
		
		return nuevoEquipo;
		
	}
	
	public Equipo<T> interseccionEquipos(Equipo<T> equipo) throws EquipoException {
		
		Equipo<T> interseccion = null;
		if(equipo != null) {
			
			interseccion = new Equipo<T>("Interseccion-" + this.nombreEquipo + equipo.nombreEquipo);
			
			if(equipo.miembrosEquipo.isEmpty()) {
				
				throw new EquipoException("El equipo no tiene ningún miembro.");
				
			}
			
			for(T elemento : equipo.miembrosEquipo) {
				
				if(this.miembrosEquipo.contains(elemento)) {
					
					interseccion.miembrosEquipo.add(elemento);
					
				}
				
			}
			
		}
		
		return interseccion;
		
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipo [nombreEquipo=");
		builder.append(nombreEquipo);
		builder.append(", miembrosEquipo=");
		builder.append(miembrosEquipo);
		builder.append("]");
		return builder.toString();
	}
	
}
