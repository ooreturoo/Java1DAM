package ej_1;

import java.util.ArrayList;

public class Equipo {

	private String nombreEquipo;
	private ArrayList<Alumno> miembrosEquipo;
	
	public Equipo(String nombreEquipo) {
		miembrosEquipo = new ArrayList<Alumno>();
		this.nombreEquipo = nombreEquipo;
	}

	
	public void añadirMiembroEquipo(Alumno alumno) throws AlumnoException {
		
		if(buscarAlumno(alumno) != null) {
			
			throw new AlumnoException("El alumno ya existe en el equipo.");
			
		}
		
		this.miembrosEquipo.add(alumno);
		
	}
	
	public void eliminarMiembro(Alumno alumno) throws AlumnoException {
		
		if(buscarAlumno(alumno) == null) {
			
			throw new AlumnoException("El alumno no pertenece al equipo.");
			
		}
		
		this.miembrosEquipo.remove(alumno);
		
	}
	
	public Alumno buscarAlumno(Alumno alumnoBuscar) {
		
		Alumno alumnoEncontrado = null;
		
		for(Alumno alumno : this.miembrosEquipo) {
			
			if(alumno.equals(alumnoBuscar)) {
				alumnoEncontrado = alumno;
			}
			
		}
		
		return alumnoEncontrado;
		
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
