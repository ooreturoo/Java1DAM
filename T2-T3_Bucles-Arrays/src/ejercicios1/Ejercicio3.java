package ejercicios1;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		int num1;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce un n�mero");
		num1 = Integer.parseInt(scan.nextLine());
		
		if(num1 % 2 == 0) {
			System.out.println("El n�mero es m�ltiplo de 2");
			if (num1 % 3 == 0) {
				System.out.println("El n�mero es m�ltiplo de 3");
			}
		}else if(num1 % 3 == 0) {
			System.out.println("El n�mero es m�ltiplo de 3");
		}
	
		scan.close();
		
	}
	

}
