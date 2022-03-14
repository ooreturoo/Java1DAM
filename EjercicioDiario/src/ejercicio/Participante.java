package ejercicio;

public class Participante {

	private String nombre;
	private int telefono;
	private String dni;
	private double velMedia;
	private double tiempoTotalH;
	private double[] vTramos;
	
	public Participante() {
		
		vTramos = new double[Carrera.getCantidadTramos()];
	}

	
	public static boolean comprobarLetra(String dni) {
		String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		int numsDNI = Integer.parseInt(dni.substring(0,dni.length() - 2));
		
		
		return letrasDNI.charAt(numsDNI%23) == dni.charAt(dni.length() - 1);
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws CampoValidoException {
		
		if(nombre.isEmpty()) {
			throw new CampoValidoException("No se puede dejar el campo nombre vacío.");
		}
		
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) throws CampoValidoException {
		
		if(telefono < 600000000 || telefono >= 800000000 ) {
			
			throw new CampoValidoException("El número de telefono introducido no es válido.");
			
		}
		
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws CampoValidoException {
		
		if(!dni.matches("^\\d{7}[A-Z]{1}")) {
			
			throw new CampoValidoException("Longitud del dni inválida.");
		
		}

		
		this.dni = dni;
	}

	public double getVelMedia() {
		return velMedia;
	}

	public void setVelMedia(double velMedia) {
		this.velMedia = velMedia;
	}

	public void setTiempoTotalH() {
		
		int velocidadT = 0;
		
		for(int i = 0; i < vTramos.length; i++) {
			
			velocidadT += vTramos[i];
			
		}
		
	}


	public double[] getvTramos() {
		return vTramos;
	}


	
	
}
