package Practico_4;

import java.util.concurrent.Semaphore;

public class Taxi {
	Semaphore subir;
	Semaphore viajando;
	Semaphore bajar;
	
	public Taxi() {
		this.subir=new Semaphore(1);
		this.viajando=new Semaphore(0);
		this.bajar=new Semaphore(0);
	}
	
	public boolean subirTaxi() {
		boolean exito=false;
		try {
			this.subir.acquire();
			exito=true;
			this.viajando.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exito;
	}
	
	public void iniciarViaje() {
		try {
			this.viajando.acquire();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void finalizarViaje() {
		this.bajar.release();
	}
	
	public void bajarTaxi() {
		try {
			this.bajar.acquire();
			System.out.println(Thread.currentThread().getName()+ " pago y se bajo del taxi");
			this.subir.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
