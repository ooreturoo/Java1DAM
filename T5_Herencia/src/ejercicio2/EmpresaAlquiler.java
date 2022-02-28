package ejercicio2;

import Leer.Leer;

public class EmpresaAlquiler {
	private final int MAX_VEHICULOS = 200;
	private Vehiculo[] vehiculos = new Vehiculo[MAX_VEHICULOS];
	private final double PRECIO_GAMA_BAJA = 30;
	private final double PRECIO_GAMA_MEDIA = 40;
	private final double PRECIO_GAMA_ALTA = 50;
	private final double PRECIO_GASOLINA = 3.5;
	private final double PRECIO_DIESEL = 2;
	private final double PRECIO_PLAZAS = 5;
	private final double PRECIO_PMA = 0.5;
	
	
	public void altaVehiculo() {
		boolean alquileresCompleto = true;
		int huecoLibre = 0;
		for(int i = 0; i < vehiculos.length && alquileresCompleto; i++) {
			if(vehiculos[i] == null) {
				alquileresCompleto = false;
				huecoLibre = i;
			}
		}
		if(alquileresCompleto) {
			System.out.println("La empresa tiene todos los vehículos alquilados.");
		}else {
			String matricula = generarMatricula();
			
			boolean gamaCorrecta = false;
			Gama gama = null;
			while(!gamaCorrecta) {
				String gamaIntroducida = Leer.lecturaString("Introduce la gama del vehículo.(baja, media, alta)").toLowerCase();
				if(gamaIntroducida.equals("baja")) {
					gama = Gama.BAJA;
					gamaCorrecta = true;
				}else if(gamaIntroducida.equals("media")) {
					gama = Gama.MEDIA;
					gamaCorrecta = true;
				}else if(gamaIntroducida.equals("alta")) {
					gama = Gama.ALTA;
					gamaCorrecta = true;
				}else {
					System.out.println("La gama introducida no es válida.");
				}
			}
			String tipoVehiculo = null;
			boolean tipoValido = false;
			while(!tipoValido) {
				tipoVehiculo = Leer.lecturaString("Introduce el tipo de vehiculo que quiere alquilar"
						+ " (Coche, Microbus o Furgoneta)").toLowerCase();
				if(tipoVehiculo.equals("coche")) {
					boolean combustibleValido = false;
					String tipoCombustible = null;
					while(!combustibleValido) {
						tipoCombustible = Leer.lecturaString("Introduce le tipo de combustible(Gasolina o Diesel)").toLowerCase();
						if(tipoCombustible.equals("gasolina")) {
							combustibleValido = true;
						}else if(tipoCombustible.equals("diesel")) {
							combustibleValido = true;
						}else {
							System.out.println("No has introducido el combustible correctamente.");
						}
					}
					
					vehiculos[huecoLibre] = new Coche(matricula, gama, tipoCombustible);
					tipoValido = true;
				}else if(tipoVehiculo.equals("microbus")) {
					int plazas = Leer.lecturaInt("Introduce las plazas del microbus.(De 8 a 20 plazas)", 8, 20);
					vehiculos[huecoLibre] = new MicroBus(matricula, gama, plazas);
					tipoValido = true;
				}else if(tipoVehiculo.equals(tipoVehiculo)) {
					int pma = Leer.lecturaInt("Introduce el PMA(Max: 3500)", 0, 3500);
					vehiculos[huecoLibre] = new FurgonetaDeCarga(matricula, gama, pma);
					tipoValido = true;
				}else {
					System.out.println("Tipo de vehículo no válido.");
				}
			System.out.println("Los datos registrados son: " + vehiculos[huecoLibre]);	
			}
		}
		
	}
	
	
	public void calculoPrecio(String matricula) {
		Vehiculo vehiculo = null;
		boolean matriculaEncontrada = false;
		for(int i = 0; i < vehiculos.length && !matriculaEncontrada; i++) {
			if(matricula.equals(vehiculos[i].getMatricula())) {
				vehiculo = vehiculos[i];
				matriculaEncontrada = true;
			}
		}
		
		if(!matriculaEncontrada) {
			System.out.println("No se ha encontrado ningun vehículo registrado con esa matrícula.");
		}else {
			double precio = precioPorGama(vehiculo.getGamaVehiculo());
		
			if(vehiculo.getClass().equals(Coche.class)) {
				Coche coche = (Coche) vehiculo;
				int dias = Leer.lecturaInt("Introduce los dias de alquiler del coche.", 1 , true);
				precio += precioCombustible(coche, dias);
				
			}else if(vehiculo.getClass().equals(MicroBus.class)) {
				MicroBus bus = (MicroBus) vehiculo;
				precio += precioPlazas(bus);
			}else{
				FurgonetaDeCarga furgo = (FurgonetaDeCarga) vehiculo;
				precio += precioPMA(furgo);
			}
			
			
			vehiculo.setPrecioAlquiler(precio);
			System.out.println("El precio de alquiler del vehículo es de: " + vehiculo.getPrecioAlquiler() + " euros.");
		}
		
	}
	
	
	private double precioPorGama(Gama gama) {
		double precioGama = 0;
		if(gama == Gama.BAJA) {
			precioGama = PRECIO_GAMA_BAJA;
		}else if(gama == Gama.MEDIA) {
			precioGama = PRECIO_GAMA_MEDIA;
		}else {
			precioGama = PRECIO_GAMA_ALTA;
		}
		return precioGama;
	}
	
	
	private double precioCombustible(Coche coche, int dias) {
		double precioCombustible = 0;
		if(coche.getTipoCombustible().equals("gasolina")) {
			precioCombustible = PRECIO_GASOLINA * dias;
		}else {
			precioCombustible = PRECIO_DIESEL * dias;
		}
		return precioCombustible;
	}
	
	
	private double precioPlazas(MicroBus bus) {
		return PRECIO_PLAZAS * bus.getPlazas();
	}
	
	
	private double precioPMA(FurgonetaDeCarga furgo) {
		return PRECIO_PMA * furgo.getPesoMaximo();
	}
	
	
	private String generarMatricula () {
		StringBuilder matricula = new StringBuilder(6);
		for(int i = 0; i < 4; i++) {
			int numero = (int) Math.round(Math.random() * 9);
			matricula.append(String.valueOf(numero));
		}
		for(int i = 0; i < 3; i++) {
			char letra = (char) (Math.round(Math.random() * (90-65)) + 65);
			matricula.append(letra);
		}
		return matricula.toString();
	}
	
}
