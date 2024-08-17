package Practico4;

import java.util.concurrent.Semaphore;

public class Jaula {

	private Semaphore plato;
	private Semaphore rueda;
	private Semaphore hamaca;
	
	public Jaula() {
		this.plato= new Semaphore(1);
		this.rueda= new Semaphore(1);
		this.hamaca= new Semaphore(1);		
	}
	
	public void usarPlato(){
		try {
			this.plato.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void liberarPlato() {
		this.plato.release();
	}
	
	public void usarRueda(){
		try {
			this.rueda.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void liberarRueda() {
		this.rueda.release();
	}
	
	public void usarHamaca() {
		try {
			this.hamaca.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void liberarHamaca() {
		this.hamaca.release();
	}
	
}
