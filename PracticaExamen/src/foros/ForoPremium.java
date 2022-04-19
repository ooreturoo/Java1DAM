package foros;

import java.time.LocalDate;

public class ForoPremium extends ForoPlus {

	private Usuario moderador;
	
	public ForoPremium(double precioSuscripcion, Usuario moderador) {
		
		super(precioSuscripcion);
		this.moderador = moderador;
	
	}
	
	public ForoPremium(LocalDate fechaCreacion, double precioSuscripcion, Usuario moderador) {
		super(fechaCreacion, precioSuscripcion);
		this.moderador = moderador;
	}
	
	public void moderar(Usuario usuario) {
		
		int posUsuario = obtenerPosisionUsuario(usuario);
		
		if(posUsuario == -1) {
			
			System.out.println("Ese usuario no se encuentra registrado.");
			
		}else {
			
			usuarios[posUsuario] = null;
			System.out.println("El usuario " + usuario.getNombreUsuario() + " ha sido eliminado con exito.");
			
		}
		
		
	}
	
	private int obtenerPosisionUsuario(Usuario usuario) {
		
		boolean usuarioEncontrado = false;
		int posUsuario = -1;
		
		for(int i = 0; i < usuarios.length && !usuarioEncontrado; i++) {
			
			if(usuarios[i].equals(usuario)) {
				
				usuarioEncontrado = true;
				posUsuario = i;
				
			}
			
		}
		
		return posUsuario;
		
	}

	@Override
	public String toString() {
		return super.toString() + "\nModerador=" + moderador;
	}

	
	
}
