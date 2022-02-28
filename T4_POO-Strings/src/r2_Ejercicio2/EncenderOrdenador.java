package r2_Ejercicio2;

public class EncenderOrdenador {
	public static void main(String[] args) {
		DiscoDuro dc = new DiscoDuro("Samsung", "SSD", 1000);
		Microprocesador mc = new Microprocesador("Intel", "Core i5-9500", 6, 3.5f, "Socket 1151");
		PlacaBase pb = new PlacaBase("Asus", "TUF Gaming", "Socket 1151");
		TarjetaGrafica tg = new TarjetaGrafica("Nvidia", "GTX 1080 G1 Gaming", 5, 1.6f, 8);
		Ordenador pc = new Ordenador();
		pc.setDiscoDuro(dc);
		pc.setMicroProcesador(mc);
		pc.setPlacaBase(pb);
		pc.setTarjetaGrafica(tg);
		
		if(pc.getMicroProcesador() == null || pc.getPlacaBase() == null) {
			System.out.println("Al ordenador le falta el procesador o la placa base.");
		}else {
			System.out.println("El ordenador funciona correctamente");
		}
		
	}
}
