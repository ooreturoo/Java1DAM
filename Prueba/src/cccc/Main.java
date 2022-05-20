package cccc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Object obj = null;
		try (FileInputStream fis = new FileInputStream("src/objeto.tmp");
	             ObjectInputStream ois = new ObjectInputStream(fis)) {
	            obj = ois.readObject();
	        }
		
		System.out.println(obj.getClass());
		
	}
	
}
