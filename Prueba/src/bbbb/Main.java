package bbbb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		Punto2D p = crearPunto();
		FileOutputStream fos = new FileOutputStream(new File("src/objeto.tmp"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p);
		oos.close();
	}

	private static Punto2D crearPunto() {
		Punto2D p = new Punto2D();
		p.setX(4);
		p.setY(25);
		return p;
	}
	
}
