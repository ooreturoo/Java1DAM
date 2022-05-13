package clases;

import java.time.LocalDate;
import java.util.Objects;

public class DatosUsuario {

	private String usuario;
	private String nombre;
	private String email;
	private LocalDate fechaNachimiento;
	
	public DatosUsuario(String usuario, String nombre, String email) {
		
		this.usuario = usuario;
		this.nombre = nombre;
		this.email = email;
		
	}
	
	public DatosUsuario(String usuario, String nombre, String email, LocalDate fechaNacimiento) {
		
		this.usuario = usuario;
		this.nombre = nombre;
		this.email = email;
		this.fechaNachimiento = fechaNacimiento;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNachimiento() {
		return fechaNachimiento;
	}

	public void setFechaNachimiento(LocalDate fechaNachimiento) {
		this.fechaNachimiento = fechaNachimiento;
	}

	public String getUsuario() {
		return usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatosUsuario other = (DatosUsuario) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "DatosUsuario [usuario=" + usuario + ", nombre=" + nombre + ", email=" + email + ", fechaNachimiento="
				+ fechaNachimiento + "]";
	}
	
	
	
}
