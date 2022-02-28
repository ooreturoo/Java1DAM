package r1_Ejercicio3;

import java.text.DecimalFormat;

import Leer.Leer;

public class Maquina {
	private int depositoCafe;
	private static final int CAP_D_CAFE = 50;
	private int depositoLeche;
	private static final int CAP_D_LECHE= 50;
	private int depositoVasos;
	private static final int CAP_D_VASOS= 80;
	private double monedero;
	private static final Maquina MAQUINA = new Maquina();//Creamos una instancia de m�quina, para que solo haya una.

	public static Maquina getMaquina() {//Obtenemos la instancia del objeto que hemos guardado.
		return MAQUINA;
	}
	
	/**
	 * Constructor que no permite crear más objetos fuera de la clase.
	 */
	private Maquina() {
		this.depositoCafe = CAP_D_CAFE;
		this.depositoLeche = CAP_D_LECHE;
		this.depositoVasos = CAP_D_VASOS;
		this.monedero = 10;
	}
	
	
	/**
	 * Rellena los dep�sitos de la m�quina
	 */
	public void llenarDepositos() {
		this.depositoCafe = CAP_D_CAFE;
		this.depositoLeche = CAP_D_LECHE;
		this.depositoVasos = CAP_D_VASOS;
		System.out.println("Maquina recargada");
	}
	
	/**
	 * Vacia el monedero.
	 */
	public void vaciarMonedero() {
		if (this.monedero > 0) {//Si el monedero tiene algo de dinero lo retira.
			this.monedero = 0;
			System.out.println("Se ha vaciado el monedero.");
		} else {//Si el monedero est� vac�o manda un aviso.
			System.out.println("El monedero ya est� vac�o");
		}
	}

	
	/**
	 * Sirve el producto elegido por el usuario.
	 * @param numSeleccionado N�mero introducido por el usuario en el menu.
	 */
	public void servirCafe(int numSeleccionado) {

		switch (numSeleccionado) {
		case 1: {
			/*
			 * Comprueba si los depositos no estan vacios. Si alguno est� vac�o se avisa al usuario y no se entrega
			 * el producto. Si hay suficientes recursos en la m�quina se sirve al usuario.
			 */
			if (depositoCafe == 0) {
				System.out.println("Deposito de caf� vac�o. No se puede entregar el producto.");
			} else if (depositoVasos == 0) {
				System.out.println("Deposito de vasos vac�o. No se puede entregar el producto.");
			} else if (cobro(1)) {
				
				/*
				 * Se restan los recursos utilizados y se sirve el producto.
				 */
				depositoCafe--;
				depositoVasos--;
				System.out.println("Producto servido.");

			}
			break;
		}
		case 2: {
			/*
			 * Comprueba si los depositos no estan vacios. Si alguno est� vac�o se avisa al usuario y no se entrega
			 * el producto. Si hay suficientes recursos en la m�quina se sirve al usuario.
			 */
			if (depositoLeche == 0) {
				System.out.println("Deposito de leche vac�o. No se puede entregar el producto.");
			} else if (depositoVasos == 0) {
				System.out.println("Deposito de vasos vac�o. No se puede entregar el producto.");
			} else if (cobro(0.8)) {
				/*
				 * Se restan los recursos utilizados y se sirve el producto.
				 */
				depositoLeche--;
				depositoVasos--;
				System.out.println("Producto servido.");

			}
			break;
		}
		case 3: {
			/*
			 * Comprueba si los depositos no estan vacios. Si alguno est� vac�o se avisa al usuario y no se entrega
			 * el producto. Si hay suficientes recursos en la m�quina se sirve al usuario.
			 */
			if (depositoLeche == 0) {
				System.out.println("Deposito de leche vac�o. No se puede entregar el producto.");
			} else if (depositoCafe == 0) {
				System.out.println("Deposito de caf� vac�o. No se puede entregar el producto.");
			} else if (depositoVasos == 0) {
				System.out.println("Deposito de vasos vac�o. No se puede entregar el producto.");
			} else if (cobro(1.5)) {
				/*
				 * Se restan los recursos utilizados y se sirve el producto.
				 */
				depositoCafe--;
				depositoLeche--;
				depositoVasos--;
				System.out.println("Producto servido.");

			}
			break;
		}

		}

	}
	
	/**
	 * Se encarga de pedir el dinero al usuario y si procede, se le devuelve el cambio al usuario.
	 * @param precioProducto Recibe el costo del producto.
	 * @return Devuelve verdadero si la m�quina tiene suficiente dinero para devolver el cambio al usuario o si ha introducido
	 * el dinero justo. En caso contrario devuelve false.
	 */
	private boolean cobro(double precioProducto) {
		double dineroUsuario = Leer.lecturaInt("Introduce el dinero.");
		if (dineroUsuario > precioProducto) {//Comprueba si el dinero introducido por el usuario es mayor que el precio el producto.
			if (monedero >= dineroUsuario - precioProducto) {//Comprueba si la m�quina tiene suficiente dinero para el cambio.
				monedero += precioProducto;//Se suma al monedero el valor del producto.
				System.out.printf("Recoge tu cambio de %.2f�\n", (dineroUsuario - precioProducto));//Entrega al usuario su cambio.
				return true;
			} else {//Si la maquina no tiene cambio avisa al usuario.
				System.out.println("La maquina no tiene cambio para dar");
				return false;
			}
		} else if (dineroUsuario == precioProducto) {//Si el dinero introducido por el usuario es el mismo que el precio devuelve true.
			return true;
		} else {//Si el usuario introduce menos dinero del necesario, se le avisa y devuelve false.
			System.out.print("Cantidad introducida no v�lida.");
			return false;
		}
	}
	
	/**
	 * Muestra el estado de la m�quina.
	 */
	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("Deposito Caf�: ");
		bf.append(this.depositoCafe);
		bf.append(" | Deposito Leche: ");
		bf.append(this.depositoLeche);
		bf.append(" | Deposito Vasos: ");
		bf.append(this.depositoVasos);
		bf.append("\nMonedero: ");
		bf.append(new DecimalFormat("0.00").format(this.monedero));
		
		return bf.toString();
	}

}
