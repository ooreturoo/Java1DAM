package ejercicios3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejercicio1_3 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[3];
		
		System.out.println("Introduce tres números para ordenarlos: ");
		num[0] = Integer.parseInt(reader.readLine());
		System.out.println("Introduce el segundo: ");
		num[1] = Integer.parseInt(reader.readLine());
		System.out.println("Introduce el último número: ");
		num[2] = Integer.parseInt(reader.readLine());
		
		Arrays.sort(num);
		
		for(int i : num) {
			System.out.println(i);
		}
		reader.close();
	}

}
