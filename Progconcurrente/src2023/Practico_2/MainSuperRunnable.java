package Practico_2;

public class MainSuperRunnable {

	public static void main(String[] args) {
		
		ClienteSuper cliente1 = new ClienteSuper("Cliente 1", new int[] { 2, 2, 1, 5,	2, 3 });
		ClienteSuper cliente2 = new ClienteSuper("Cliente 2", new int[] { 1, 3, 5, 1,	1 });
		
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		CajeroRunnable cajero1=new CajeroRunnable(cliente1, "Cajero 1", initialTime);
		CajeroRunnable cajero2=new CajeroRunnable(cliente2, "Cajero 2", initialTime);
		
		Thread hilojCajero1=new Thread(cajero1,"Hilo 1");
		Thread hilojCajero2=new Thread(cajero2,"Hilo 2");
		
		hilojCajero1.start();
		hilojCajero2.start();
		
		}
	
}
