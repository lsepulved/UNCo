package Practico_2;

public class MainThread {
	
	public static void main(String[] args) {
		
		ClienteSuper cliente1 = new ClienteSuper("Cliente 1", new int[] { 2, 2, 1, 5,	2, 3 });
		ClienteSuper cliente2 = new ClienteSuper("Cliente 2", new int[] { 1, 3, 5, 1,	1 });
		
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		CajeroThread cajero1=new CajeroThread(cliente1, "Cajero 1", initialTime);
		CajeroThread cajero2=new CajeroThread(cliente2, "Cajero 2", initialTime);
		
		cajero1.start();
		cajero2.start();
		
		}

}
