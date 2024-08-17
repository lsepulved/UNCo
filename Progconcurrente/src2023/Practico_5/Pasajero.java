package Practico_5;

public class Pasajero implements Runnable{

	Tren tren;
	
	public Pasajero(Tren unTren) {
		this.tren=unTren;
	}
	
	public void run() {
		this.tren.comprarTicket();
		this.tren.subirTren();
		this.tren.bajar();
	}
}
