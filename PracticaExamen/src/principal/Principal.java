package principal;

import java.time.LocalDate;

import enums.CategoriaMensajes;
import enums.CodecVideo;
import enums.FormatoAudio;
import excepciones.RegistroException;
import foros.ForoBasico;
import foros.ForoPlus;
import foros.ForoPremium;
import foros.Usuario;
import mensajes.MensajeAudio;
import mensajes.MensajeImagen;
import mensajes.MensajeTexto;
import mensajes.MensajeVideo;

public class Principal {

	public static void main(String[] args) {
		
		Usuario moderador = new Usuario("Sebastian", "moderador", "dfasfsa@gmail.com" , LocalDate.of(1997, 9, 18));
		Usuario usuario1 = new Usuario("Pepe", "pepito", "fsfsa@gmail.com", LocalDate.of(2003, 12, 10));
		Usuario usuario2 = new Usuario("Menor", "chiquito", "dfaf@gmail.com", LocalDate.of(2007, 5, 3));
		Usuario usuario3 = new Usuario("Julia", "jlcs", "dfafsd@gmail.com", LocalDate.of(2000, 2, 17));
		Usuario usuario4 = new Usuario("Jose", "josesito", "gfdgr3@gmail.com", LocalDate.of(1997, 5, 5));
		Usuario usuario5 = new Usuario("Rocio", "roc2342", "ro323f@gmail.com", LocalDate.of(2003, 10, 13));
		Usuario usuario6 = new Usuario("Israel", "israfd", "df435af@gmail.com", LocalDate.of(2002, 7, 21));
		MensajeTexto mensajeTexto1 = new MensajeTexto(usuario1, "mensaje texto 1", CategoriaMensajes.DEPORTE);
		MensajeTexto mensajeTexto2 = new MensajeTexto(usuario2, "mensaje texto 2" ,CategoriaMensajes.ESPORTS);
		MensajeImagen mensajeImagen1 = new MensajeImagen(usuario1, "mensaje imagen 1", CategoriaMensajes.ESPORTS, 50, 50);
		MensajeImagen mensajeImagen2 = new MensajeImagen(usuario3, "mensaje imagen 2", CategoriaMensajes.EVENTOS, 150, 150);
		MensajeAudio mensajeAudio1 = new MensajeAudio(usuario3, "mensaje audio 1", CategoriaMensajes.HUMOR, FormatoAudio.MP3, 1);
		MensajeAudio mensajeAudio2 = new MensajeAudio(usuario4, "mensaje audio 2",CategoriaMensajes.OTROS,FormatoAudio.AAC, 1200);
		MensajeVideo mensajeVideo1 = new MensajeVideo(usuario5, "mensaje video 1", CategoriaMensajes.EVENTOS, CodecVideo.H264, 10, 30);
		MensajeVideo mensajeVideo2 = new MensajeVideo(usuario6, "mensaje video 2", CategoriaMensajes.HUMOR, CodecVideo.MPEG4, 15, 10);
		
		ForoBasico fBasico = new ForoBasico();
		ForoPlus fPlus = new ForoPlus(LocalDate.of(2021, 12, 20),12.5);
		ForoPremium fPremium = new ForoPremium(LocalDate.of(2021, 11, 20),18.99, moderador);
		
		System.out.println("\n ****REGISTRO USUARIOS**** \n");
		
		try {
			fBasico.registarUsuario(usuario1);
		} catch (RegistroException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			fBasico.registarUsuario(usuario5);
		} catch (RegistroException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			fPlus.registarUsuario(usuario2);
		} catch (RegistroException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			fPlus.registarUsuario(usuario3);
		} catch (RegistroException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			fPremium.registarUsuario(usuario4);
		} catch (RegistroException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			fPremium.registarUsuario(usuario6);
		} catch (RegistroException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("\n ****VISTA DE LOS MENSAJES**** \n");
		
		System.out.println(mensajeTexto1);
		System.out.println(mensajeTexto2);
		System.out.println(mensajeImagen1);
		System.out.println(mensajeImagen2);
		System.out.println(mensajeVideo1);
		System.out.println(mensajeVideo2);
		System.out.println(mensajeAudio1);
		System.out.println(mensajeAudio2);
		
		
		System.out.println("\n ****INTRODUCCION MENSAJES A FOROS**** \n");
		

		fBasico.publicarMensaje(mensajeTexto1);
		fBasico.publicarMensaje(mensajeImagen1);
		fBasico.publicarMensaje(mensajeVideo1);
		fPlus.publicarMensaje(mensajeTexto2);
		fPlus.publicarMensaje(mensajeImagen2);
		fPlus.publicarMensaje(mensajeAudio1);
		fPremium.publicarMensaje(mensajeAudio2);
		fPremium.publicarMensaje(mensajeVideo2);
		
		System.out.println("\n ****PESO TOTAL MENSAJES FOROS**** \n");
		
		System.out.println(fBasico.pesoTotalMensajes());
		System.out.println(fPlus.pesoTotalMensajes());
		System.out.println(fPremium.pesoTotalMensajes());
		
		System.out.println("\n ****DINERO RECAUDADO**** \n");
		
		System.out.println(fPlus.dineroRecaudado());
		System.out.println(fPremium.dineroRecaudado());
		
		System.out.println("\n ****MODERAR FORO**** \n");
		
		fPremium.moderar(usuario6);

		
	}
	
}
