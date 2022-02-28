package construcciones.clases;



import recursos.clases.MateriaPrima;

public abstract class Construccion {
	
	public final MateriaPrima[] COSTES_CONSTRUCCION;
	public final int PERSONAS_NECESARIAS;
	
	public Construccion(int personasNecesarias, MateriaPrima[] costesConstruccion) {
		
		this.COSTES_CONSTRUCCION = costesConstruccion;
		this.PERSONAS_NECESARIAS = personasNecesarias;
		
	}
	
	

	
	
}
