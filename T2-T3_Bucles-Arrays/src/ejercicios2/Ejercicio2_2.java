package ejercicios2;
import java.util.Scanner;

public class Ejercicio2_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		boolean interruptor = true;
		
		while(interruptor) {
			try {
				System.out.println("Introduce un número del 0 al 10");
				num = Integer.parseInt(scan.nextLine());
				if(num <= 10 && num >= 0)
					interruptor = false;
				
			} catch (Exception e) {
				System.out.println("Error al introducir el número");
			}
		}
		
		for(int i = 0; i<=10; i++){
			System.out.println(num + " * " + i + " = " + num*i);
		}
		scan.close();
	}

}
