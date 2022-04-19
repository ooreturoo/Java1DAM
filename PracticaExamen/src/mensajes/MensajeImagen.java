package mensajes;



import enums.CategoriaMensajes;
import foros.Usuario;
import funcionalidades.Funcionalidades;

public class MensajeImagen extends MensajeTexto {
	
	private static final int BYTE_POR_PIXEL = 24;
	
	private int anchoImagen;
	private int altoImagen;

	public MensajeImagen(Usuario autor, String texto, CategoriaMensajes categoria,
			int anchoImagen, int altoImagen) {
		super(autor, texto, categoria);
		
		this.anchoImagen = anchoImagen;
		this.altoImagen = altoImagen;
		
	}
	
	@Override
	public double calcularPeso() {
		
		double bytes = pixelesImagen() * BYTE_POR_PIXEL;
		
		return Funcionalidades.pasarAMegaBytes(bytes) + calcularPesoTexto();
	}
	
	
	private int pixelesImagen() {
		
		return anchoImagen * altoImagen;
		
	}

	@Override
	public String toString() {
		return super.toString() + ", AnchoImagen=" + anchoImagen + ", AltoImagen=" + altoImagen;
	}

	
	
}
