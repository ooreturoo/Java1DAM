package mensajes;


import enums.CategoriaMensajes;
import enums.CodecVideo;
import foros.Usuario;

public class MensajeVideo extends MensajeTexto {

	private CodecVideo codec;
	private int fps;
	private int duracionSegundos;
	
	public MensajeVideo(Usuario autor, String texto, CategoriaMensajes categoria,
			CodecVideo codec, int fps, int duracionSegundos) {
		super(autor, texto, categoria);
		
		this.codec = codec;
		this.fps = fps;
		this.duracionSegundos= duracionSegundos;
		
	}
	
	@Override
	public double calcularPeso() {
		
		double bytes = (fps*duracionSegundos) * codec.getMegabytes();
		
		return bytes + calcularPesoTexto();
		
	}

	@Override
	public String toString() {
		return super.toString() + ", Codec=" + codec + ", Fps=" + fps + ", DuracionSegundos=" + duracionSegundos;
	}
	
	 

}
