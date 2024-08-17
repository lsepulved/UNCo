package Practico5;

public class Pasajero implements Runnable{
	
	Tren tren;
	
	public Pasajero(Tren unTren) {
		this.tren=unTren;
	}
	
	public void run() {
		
		this.tren.comprarTicket();
		System.out.println(Thread.currentThread().getName()+" comprando tickets");
		
		this.tren.subir();
		System.out.println(Thread.currentThread().getName()+" subo al tren");
		
		this.viajar();
		
		this.tren.bajar();
		System.out.println(Thread.currentThread().getName()+" bajo del tren");
		this.viajar();
	}
	
	public void viajar() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
