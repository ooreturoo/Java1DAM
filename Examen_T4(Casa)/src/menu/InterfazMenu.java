package menu;

public class InterfazMenu {

	public static void mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n**********Menu Biblioteca**********");
		sb.append("\n1.A�adir Pel�cula.");
		sb.append("\n2.Consultar Biblioteca.");
		sb.append("\n3.Buscar Pel�cula por Etiqueta.");
		sb.append("\n4.Buscar Pel�cula por T�tulo.");
		sb.append("\n5.Buscar Pel�cula por Presupuesto M�ximo");
		sb.append("\n6.Salir.\n");
		
		System.out.println(sb);
	}
	
	
}
