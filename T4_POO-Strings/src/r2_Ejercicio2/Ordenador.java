package r2_Ejercicio2;

public class Ordenador {
	private DiscoDuro discoDuro;
	private Microprocesador microProcesador;
	private PlacaBase placaBase;
	private TarjetaGrafica tarjetaGrafica;
	public DiscoDuro getDiscoDuro() {
		return discoDuro;
	}
	public void setDiscoDuro(DiscoDuro discoDuro) {
		this.discoDuro = discoDuro;
	}
	public Microprocesador getMicroProcesador() {
		return microProcesador;
	}
	public void setMicroProcesador(Microprocesador microProcesador) {
		if(placaBase != null) {
			if(microProcesador.getSocket().equals(placaBase.getSocket())) {
				this.microProcesador = microProcesador;
			}else {
				System.out.println("No se puede montar el microprocesador porque el socket no es compatible con el de la placa base.");
			}
		}else {
			this.microProcesador = microProcesador;
		}
	}
	public PlacaBase getPlacaBase() {
		return placaBase;
	}
	public void setPlacaBase(PlacaBase placaBase) {
		if(microProcesador != null) {
			if(placaBase.getSocket().equals(microProcesador.getSocket())) {
				this.placaBase = placaBase;
			}else {
				System.out.println("No se puede montar la placa base porque el socket no es compatible con el microprocesador.");
			}
		}else {
			this.placaBase = placaBase;
		}
		
	}
	public TarjetaGrafica getTarjetaGrafica() {
		return tarjetaGrafica;
	}
	public void setTarjetaGrafica(TarjetaGrafica tarjetaGrafica) {
		this.tarjetaGrafica = tarjetaGrafica;
	}
	
	
}
