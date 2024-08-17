package Practico5;

import java.util.concurrent.Semaphore;

public class Tren {
	
	int cantAsientos;
	Semaphore iniciarVenta;
	Semaphore finalizarVenta;
	Semaphore tickets;
	Semaphore iniciarViaje;
	Semaphore ocuparAsiento;
	Semaphore liberarAsiento;
	Semaphore asiento;
	Semaphore viajar;
	Semaphore mutex;
	
	public Tren(int numAsientos) {
		this.cantAsientos=numAsientos;
		this.iniciarVenta=new Semaphore(numAsientos);
		this.finalizarVenta=new Semaphore(0);
		this.iniciarViaje=new Semaphore(0);
		this.asiento=new Semaphore(0);
		this.liberarAsiento=new Semaphore(0);
		this.tickets=new Semaphore(0);
		this.viajar=new Semaphore(0);
		this.mutex=new Semaphore(1);
	}

	
	//vendedor
	public void abrirVenta() {
		try {
			this.iniciarVenta.acquire(this.cantAsientos);
			this.tickets.release(this.cantAsientos);			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cerrarVenta() {
		try {
			this.finalizarVenta.acquire(this.cantAsientos);
			this.asiento.release(this.cantAsientos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//pasajero
	public void comprarTicket() {
		try {
			this.tickets.acquire();
			this.finalizarVenta.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//pasajero
	public void subir() {
		try {

			this.asiento.acquire();
			this.iniciarViaje.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//pasajero
	public void bajar() {
		
		try {
			this.liberarAsiento.acquire();
			this.iniciarVenta.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//control
	public void comenzarViaje() {
		try {
			this.iniciarViaje.acquire(this.cantAsientos);
			this.viajar.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//control
	public void finalizarViaje() {
		try {
			this.viajar.acquire();
			this.liberarAsiento.release(this.cantAsientos);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

