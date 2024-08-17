package Practico_5;

public class VendedorTickets implements Runnable {

	Tren tren;
	
	public VendedorTickets(Tren unTren) {
		this.tren=unTren;
	}
	
	public void run() {
		while (true) {
			this.tren.venderTicket();
		}
	}
}
