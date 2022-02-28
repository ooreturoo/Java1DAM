package ejercicios1;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		int num1, num2;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce dos números");
		num1 = Integer.parseInt(scan.nextLine());
		num2 = Integer.parseInt(scan.nextLine());
		
		if(num1 == num2){
			System.out.println(num1 + " y " + num2 + " son iguales");
		}else if(num1 > num2){
			System.out.println(num1 + " es mayor que " + num2);
		}else {
			System.out.println(num2 + " es mayor que " + num1);
		}
		
		scan.close();

	}

}
