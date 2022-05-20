package elementos;

import java.util.Objects;

public class Cromo implements Comparable<Cromo> {

	private int id;
	private String nombre;
	
	
	public Cromo(int id, String nombre) {
		
		super();
		this.id = id;
		this.nombre = nombre;
		
	}


	public int getId() {
		return id;
	}




	public String getNombre() {
		return nombre;
	}




	@Override
	public int hashCode() {
		
		return Objects.hash(id);
		
	}


	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cromo other = (Cromo) obj;
		return id == other.id;
		
	}


	@Override
	public int compareTo(Cromo o) {
		return nombre.compareTo(o.nombre);
	}


	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	
}
