package foros;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import excepciones.RegistroException;
import funcionalidades.Funcionalidades;
import mensajes.MensajeAudio;
import mensajes.MensajeImagen;
import mensajes.MensajeTexto;
import mensajes.MensajeVideo;

public class ForoBasico {
	
	private static final int MAXIMO_PESO_TEXTO = 1;
	private static final int MAXIMO_PESO_IMAGEN = 8;
	private static final int MAXIMO_PESO_VIDEO = 12;
	private static final int MAXIMO_PESO_AUDIO = 5;
	
	private static final int CAPACIDAD_LISTAS = 10;

	protected LocalDate fechaCreacion;
	protected Usuario[] usuarios;
	protected MensajeTexto[] mensajesTexto;
	protected MensajeImagen[] mensajesImagen;
	protected MensajeVideo[] mensajesVideo;
	protected MensajeAudio[] mensajesAudio;
	
	public ForoBasico() {
		
		this.fechaCreacion = LocalDate.now();
		this.usuarios = new Usuario[CAPACIDAD_LISTAS];
		this.mensajesTexto = new MensajeTexto[CAPACIDAD_LISTAS];
		this.mensajesImagen = new MensajeImagen[CAPACIDAD_LISTAS];
		this.mensajesVideo = new MensajeVideo[CAPACIDAD_LISTAS];
		this.mensajesAudio = new MensajeAudio[CAPACIDAD_LISTAS];
		
	}
	
	public ForoBasico(LocalDate fechaCreacion) {
		
		this.fechaCreacion = fechaCreacion;
		this.usuarios = new Usuario[CAPACIDAD_LISTAS];
		this.mensajesTexto = new MensajeTexto[CAPACIDAD_LISTAS];
		this.mensajesImagen = new MensajeImagen[CAPACIDAD_LISTAS];
		this.mensajesVideo = new MensajeVideo[CAPACIDAD_LISTAS];
		this.mensajesAudio = new MensajeAudio[CAPACIDAD_LISTAS];
		
	}
	
	public void registarUsuario(Usuario usuario) throws RegistroException {
		
		if(Math.abs(ChronoUnit.YEARS.between(usuario.getFechaNacimiento(), LocalDate.now())) < 18) {
			
			throw new RegistroException("El usuario " + usuario.getNombreUsuario() +" no puede registrarse al ser menor de edad.");
				
		}
		
		boolean usuarioRegistrado = false;
		
		for(int i = 0; i < usuarios.length && !usuarioRegistrado; i++) {
			
			if(usuarios[i] == null) {
				
				usuarios[i] = usuario;
				usuarioRegistrado = true;
			}
			
		}
		
		if(usuarioRegistrado = true) {
			
			System.out.println("Usuario registrado con exito.");
			
		}else {
			
			System.out.println("Limite de usuarios alcanzado. No ha podido regristrarse.");
			
		}
		
	}
	
	public void publicarMensaje(MensajeTexto mensaje) {
		
		
		if(pesoMensajePermitido(mensaje)) {
			
			if(usuarioRegistrado(mensaje)) {
				
				boolean mensajePublicado = false;
				
				for(int i = 0; i < CAPACIDAD_LISTAS; i++) {
					
					if(mensaje instanceof MensajeVideo && mensajesVideo[i] == null) {
						
						mensajesVideo[i] = (MensajeVideo) mensaje;
						mensajePublicado = true;
						
					}else if (mensaje instanceof MensajeAudio && mensajesAudio[i] == null) {
						
						mensajesAudio[i] = (MensajeAudio) mensaje;
						mensajePublicado = true;
						
						
					}else if (mensaje instanceof MensajeImagen && mensajesImagen[i] == null) {
						
						mensajesImagen[i] = (MensajeImagen) mensaje;
						mensajePublicado = true;
						
					}else if(mensajesTexto[i] == null) {
						
						mensajesTexto[i] = mensaje;
						mensajePublicado = true;
						
					}
					
				}
				
				if(mensajePublicado) {
					
					System.out.println("El mensaje se publicó con exito.");
					
				}else {
					
					System.out.println("Limite de mensajes alcanzado. No se ha podido publicar el mensaje.");
					
				}
				
			}else {
				
				System.out.println("Para publicar un mensaje el usuario tiene que estar registrado.");
				
			}
			
		}else {
			
			System.out.println("No se puede registrar el mensaje porque sobrepasa el peso permitido.");
			
		}
		
	}
	
	public double pesoTotalMensajes() {
		
		double bytes = 0;
		
		for(int i = 0; i < CAPACIDAD_LISTAS; i++) {
			
			if(mensajesTexto[i] != null) {
				
				bytes += mensajesTexto[i].calcularPeso();
				
			}	
			
			if(mensajesImagen[i] != null) {
				
				bytes += mensajesImagen[i].calcularPeso();
				
			}
			
			if(mensajesAudio[i] != null) {
				
				bytes += mensajesAudio[i].calcularPeso();
				
			}
			if(mensajesVideo[i] != null) {
				
				bytes += mensajesVideo[i].calcularPeso();
				
			}
				
				
			
			
		}
		
		return Funcionalidades.pasarAMegaBytes(bytes);
		
	}
	
	private boolean pesoMensajePermitido(MensajeTexto mensaje) {
		
		boolean pesoAdecuado = false;
		
		if(mensaje instanceof MensajeVideo) {
			
			pesoAdecuado = mensaje.calcularPeso() <= MAXIMO_PESO_VIDEO;
			
		}else if (mensaje instanceof MensajeAudio) {
			
			pesoAdecuado = mensaje.calcularPeso() <= MAXIMO_PESO_AUDIO;
			
			
		}else if (mensaje instanceof MensajeImagen) {
			
			pesoAdecuado = mensaje.calcularPeso() <= MAXIMO_PESO_IMAGEN;
			
		}else{
			
			pesoAdecuado = mensaje.calcularPeso() <= MAXIMO_PESO_TEXTO;
			
		}
		
		return pesoAdecuado;
		
	}
	
	private boolean usuarioRegistrado(MensajeTexto mensaje) {
		
		boolean usuarioEncontrado = false;
		
		for(int i = 0; i < usuarios.length && !usuarioEncontrado; i++) {
			
			if(mensaje.getAutor().equals(usuarios[i])) {
				
				usuarioEncontrado = true;
				
			}
			
		}
		
		return usuarioEncontrado;
		
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " FechaCreacion=" + fechaCreacion + ", Usuarios=" + Arrays.toString(usuarios)
				+ "\nMensajesTexto=" + Arrays.toString(mensajesTexto) + "\nMensajesImagen="
				+ Arrays.toString(mensajesImagen) + "\nMensajesVideo=" + Arrays.toString(mensajesVideo)
				+ "\nMensajesAudio=" + Arrays.toString(mensajesAudio) + "\nPesoTotalMensajes=" + pesoTotalMensajes() + "MB";
	}
	
	
	
}
