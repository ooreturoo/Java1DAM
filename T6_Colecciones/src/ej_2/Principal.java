package ej_2;

public class Principal {

	public static void main(String[] args) {
		
		Equipo equipo1 = new Equipo("Equipo1");
		
		try {
			equipo1.añadirMiembroEquipo(new Alumno("Pepe", "1544354"));
			equipo1.añadirMiembroEquipo(new Alumno("Pepe", "1544354"));
			equipo1.añadirMiembroEquipo(new Alumno("Manuel", "1544254"));
			equipo1.añadirMiembroEquipo(new Alumno("Rodolfo", "1544354"));
			equipo1.añadirMiembroEquipo(new Alumno("Roberto", "123454"));
			equipo1.añadirMiembroEquipo(new Alumno("Josefa", "1542321"));
			equipo1.añadirMiembroEquipo(new Alumno("Maria", "153454"));
			equipo1.añadirMiembroEquipo(new Alumno("Fernanda", "154452"));
			
		} catch (AlumnoException e) {
			
			System.out.println(e.getMessage());
			
		}
	
		
		
		Equipo equipo2 = new Equipo("Equipo2");
		try {
			equipo2.añadirMiembroEquipo(new Alumno("Josefa", "1542321"));
			equipo2.añadirMiembroEquipo(new Alumno("López", "154212"));
			equipo2.añadirMiembroEquipo(new Alumno("Fernando", "1542231"));
			equipo2.añadirMiembroEquipo(new Alumno("Juana", "12421"));
			equipo2.añadirMiembroEquipo(new Alumno("Luis", "153321"));
			equipo2.añadirMiembroEquipo(new Alumno("Roberto", "123454"));
		} catch (AlumnoException e1) {
			
			System.out.println(e1.getMessage());
			
		}
		
		
		
		Equipo fusionEquipo;
		
		try {
			fusionEquipo = equipo1.unirEquipos(equipo2);
			System.out.println("Fusion equipo:");
			fusionEquipo.mostrarEquipo();
		} catch (EquipoException e) {
			e.printStackTrace();
		}
		
		Equipo interseccion;
		
		try {
			
			interseccion = equipo1.interseccionEquipos(equipo2);
			System.out.println("Interseccion : ");
			interseccion.mostrarEquipo();
			
		} catch (EquipoException e) {

			e.printStackTrace();
		}
		
		
		Alumno alumnoBuscado = equipo1.buscarAlumno(new Alumno("Josefa", "1542321"));
		
		if(alumnoBuscado != null) {
			System.out.println(alumnoBuscado);
		}
		
		
		
	}
	
}
