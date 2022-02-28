package menu;

public class InterfazMenu {

	public static void mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n**********Menu Biblioteca**********");
		sb.append("\n1.Añadir Película.");
		sb.append("\n2.Consultar Biblioteca.");
		sb.append("\n3.Buscar Película por Etiqueta.");
		sb.append("\n4.Buscar Película por Título.");
		sb.append("\n5.Buscar Película por Presupuesto Máximo");
		sb.append("\n6.Salir.\n");
		
		System.out.println(sb);
	}
	
	
}
