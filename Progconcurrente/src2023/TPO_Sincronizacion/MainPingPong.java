package TPO_Sincronizacion;

public class MainPingPong {
	
	public static void main(String[] args) {

		Dato cuenta = new Dato();
		PingPong t1 = new PingPong ("PING", (int) (Math.random() * 2300), cuenta);
		PingPong t2 = new PingPong ("PONG", (int) (Math.random() * 2000), cuenta);

		t1.start();
		t2.start();

		
		try {
			Thread.sleep((long) Math.random() * 2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

*/
		
		System.out.println (Thread.currentThread() + " chau-chau.adios");
		System.out.println (" dato " + cuenta.obtenerValor());


		}
}

