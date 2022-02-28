package cartas.menu;

public class InterfazMenuCartas {
	
	public static StringBuilder MenuCartas() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n*******Tienda de Cartas*******");
		sb.append("\n1.Cartas Naves.");
		sb.append("\n2.Cartas Construcciones.");
		sb.append("\n3.Salir.");
		
		return sb;
	}
	
	public static StringBuilder MenuCartasNaves() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n*******Cartas Naves*******");
		sb.append("\n1.Carta Nave de Ataque.");
		sb.append("\n2.Carta Nave de Transporte.");
		sb.append("\n3.Carta Nave de Carga.");
		sb.append("\n4.Salir.");
		
		return sb;
		
	}
	
	public static StringBuilder MenuCartasConstrucciones() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n*******Cartas Construcciones*******");
		sb.append("\n1.Mina.");
		sb.append("\n2.Escudo Protector.");
		sb.append("\n3.Salir.");
		
		return sb;
	}
	
}
