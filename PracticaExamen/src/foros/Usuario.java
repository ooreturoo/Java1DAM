package foros;

import java.time.LocalDate;
import java.util.Objects;


public class Usuario {
	
	private String nombreReal;
	private String nombreUsuario;
	private String email;
	private LocalDate fechaNacimiento;
	
	public Usuario(String nombreReal, String nombreUsuario, String email, LocalDate fechaNacimiento){
		
		this.nombreReal = nombreReal;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	@Override
	public String toString() {
		return "\nUsuario [nombreReal=" + nombreReal + ", nombreUsuario=" + nombreUsuario + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fechaNacimiento, nombreReal, nombreUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombreReal, other.nombreReal) && Objects.equals(nombreUsuario, other.nombreUsuario);
	}
	
	
	
	
	
	
	
	
}
