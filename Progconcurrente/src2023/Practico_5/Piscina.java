package Practico_5;

import java.util.concurrent.Semaphore;

public class Piscina {
	
	Semaphore disponibles;
	
	public Piscina (int cantLugares) {
		this.disponibles=new Semaphore(cantLugares);
	}
	
	public void entrarPiscina() {
		try {
			this.disponibles.acquire();
			System.out.println(Thread.currentThread().getName()+ " ........entra a la piscina");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salirPiscina() {
		System.out.println(Thread.currentThread().getName()+ " ........sale de la piscina");
		this.disponibles.release();
	}

}
