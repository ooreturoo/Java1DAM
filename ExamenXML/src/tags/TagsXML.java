package tags;

public enum TagsXML {
	
	AEROPUERTO("aeropuerto"),
	CODIGO("codigo"),
	ID("id"),
	VUELO("vuelo"),
	COMPANIA("compañía"),
	HORA_SALIDA("hora_salida"),
	DESTINO("destino");
	
	private String nombre;
	
	private TagsXML(String nombre) {
		
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
}
