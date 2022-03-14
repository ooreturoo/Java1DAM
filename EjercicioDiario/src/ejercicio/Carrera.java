package ejercicio;

public class Carrera {

	private static final int MAX_PARTICIPANTES = 30;
	private static final int CANTIDAD_TRAMOS = 4;
	
	private Participante[] participantes;
	private double[] distanciaTramos;
	
	public Carrera() {
		
		participantes = new Participante[MAX_PARTICIPANTES];
		distanciaTramos = new double[CANTIDAD_TRAMOS];
		
	}
	
	public Participante[] getParticipantes() {
		return participantes;
	}
	public void setParticipantes(Participante[] participantes) {
		this.participantes = participantes;
	}
	public double[] getDistanciaTramos() {
		return distanciaTramos;
	}
	public void setDistanciaTramos(double[] distanciaTramos) {
		this.distanciaTramos = distanciaTramos;
	}
	public static int getMaxParticipantes() {
		return MAX_PARTICIPANTES;
	}
	public static int getCantidadTramos() {
		return CANTIDAD_TRAMOS;
	}
	
	
	
	
	
	
	
}
