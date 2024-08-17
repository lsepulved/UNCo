package Practico_2;

public class MainSuper {

	public static void main(String[] args) {
			ClienteSuper cliente1 = new ClienteSuper("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
			ClienteSuper cliente2 = new ClienteSuper("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
			
			Cajero cajero1 = new Cajero("Cajero 1");
			
			// Tiempo inicial de referencia
			long initialTime = System.currentTimeMillis();
			
			cajero1.procesarCompra(cliente1, initialTime);
			cajero1.procesarCompra(cliente2, initialTime);
	}
}
