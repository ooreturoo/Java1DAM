package mensajes;


import enums.CategoriaMensajes;
import enums.FormatoAudio;
import foros.Usuario;

public class MensajeAudio extends MensajeTexto{

	private FormatoAudio formato;
	private double duracionMinutos;
	
	public MensajeAudio(Usuario autor, String texto, CategoriaMensajes categoria,
			FormatoAudio formato, double duracionMinutos) {
		super(autor, texto, categoria);
		
		this.formato = formato;
		this.duracionMinutos = duracionMinutos;
	}
	
	@Override
	public double calcularPeso() {
		
		double bytes = formato.getMegabytes() * duracionMinutos;
		
		return bytes + calcularPesoTexto();
		
	}

	@Override
	public String toString() {
		return  super.toString() + ", Formato=" + formato + ", DuracionMinutos=" + duracionMinutos;
	}
	
	

}
