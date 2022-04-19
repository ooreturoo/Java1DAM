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
	
	public Equipo unirEquipos(Equipo equipo) throws EquipoException {
		
		Equipo nuevoEquipo = null;
		if(equipo != null) {
			
			nuevoEquipo = new Equipo("Fusión-" + this.nombreEquipo + equipo.nombreEquipo);
			nuevoEquipo.miembrosEquipo.addAll(this.miembrosEquipo);
			
			if(equipo.miembrosEquipo.isEmpty()) {
				
				throw new EquipoException("El equipo no tiene ningún miembro.");
				
			}
			
			for(Alumno alumno : equipo.miembrosEquipo) {
				
				if(!this.miembrosEquipo.contains(alumno)) {
					
					nuevoEquipo.miembrosEquipo.add(alumno);
					
				}
				
			}
			
		}
		
		return nuevoEquipo;
		
	}
	
	public Equipo interseccionEquipos(Equipo equipo) throws EquipoException {
		
		Equipo interseccion = null;
		if(equipo != null) {
			
			interseccion = new Equipo("Interseccion-" + this.nombreEquipo + equipo.nombreEquipo);
			
			if(equipo.miembrosEquipo.isEmpty()) {
				
				throw new EquipoException("El equipo no tiene ningún miembro.");
				
			}
			
			for(Alumno alumno : equipo.miembrosEquipo) {
				
				if(this.miembrosEquipo.contains(alumno)) {
					
					interseccion.miembrosEquipo.add(alumno);
					
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
