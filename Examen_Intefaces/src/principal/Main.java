package principal;

import enums.Formato;
import objetos.Fichero;
import objetos.FicheroAudio;
import objetos.FicheroBinario;
import objetos.FicheroEjecutable;
import objetos.FicheroImagen;
import objetos.FicheroTextoFormateado;
import objetos.FicheroTextoPlano;
import objetos.FicheroVideo;

public class Main {

	public static void main(String[] args) {
		
		Fichero[] ficheros = new Fichero[7];
		
		ficheros[0] = new FicheroAudio("Audio", 15, 15);
		ficheros[1] = new FicheroBinario("Binario", 10);
		ficheros[2] = new FicheroEjecutable("Ejecutable", 8, 6);
		ficheros[3] = new FicheroImagen("Imagen", 25, Formato.JPG);
		ficheros[4] = new FicheroTextoPlano("Plano", 35);
		ficheros[5] = new FicheroTextoFormateado("Formateado", "Arial", 25, 12, "Rojo");
		ficheros[6] = new FicheroVideo("Video", 15, 15);
		
	}
	
}
