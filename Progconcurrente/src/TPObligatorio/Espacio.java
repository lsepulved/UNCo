package TPObligatorio;

import java.util.concurrent.Semaphore;

public class Espacio {

	int cantHidrogeno;
	int cantOxigeno;
	
	private Semaphore OListo;
	private Semaphore HListo;
	
	private Semaphore oDisponible;
	private Semaphore hDisponible;

	private Semaphore oUsado;
	private Semaphore hUsado;
	
	private Semaphore hacerAtomo;

	
	public Espacio() {
		this.cantHidrogeno=0;
		this.cantOxigeno=0;
		
		this.hacerAtomo= new Semaphore(0);
		this.OListo= new Semaphore(0);
		this.HListo= new Semaphore(0);
		
		this.oUsado= new Semaphore(0);
		this.oDisponible= new Semaphore(1);
		this.hUsado= new Semaphore(0);
		this.hDisponible= new Semaphore(2);
	}
	
	
	public void hacerAtomo() throws InterruptedException {
		if (this.cantHidrogeno>=2 && this.cantOxigeno>=1) {
			System.out.println("=================Detener Generacion de Atomos");
			this.hacerAtomo.acquire();	
		}
		
	}
	
	public void liberarOxigeno() throws InterruptedException {
		this.oDisponible.acquire();
		this.OListo.release();;
	}

	public void liberarHidrogeno() throws InterruptedException {
		this.hDisponible.acquire();
		this.HListo.release();
	}
	
	public void incrementarOxigeno() {
		this.cantOxigeno++;
	}
	
	public void decrementarOxigeno() {
		this.cantOxigeno--;
	}
	
	public void incrementarHidrogeno() {
		this.cantHidrogeno++;
	}
	
	public void decrementarHidrogeno() {
		this.cantHidrogeno--;
	}
	
	public int getCantHidrogeno() {
		return this.cantHidrogeno;
	}
	
	public int getCantOxigeno() {
		return this.cantOxigeno;
	}
	
	public void usarOxigeno() throws InterruptedException{
		this.oUsado.acquire();
		this.cantOxigeno--;
		this.oDisponible.release();
	}

	public void usarHidrogeno() throws InterruptedException {
		this.hUsado.acquire();
		this.cantHidrogeno--;
		this.hDisponible.release();
	}
		
	public void hacerAgua() throws InterruptedException {
		this.OListo.acquire();
		this.HListo.acquire(2);
//		System.out.println("========================SE HIZO AGUA");
		this.oUsado.release();
		this.hUsado.release(2);
		this.hacerAtomo.release();
	}
	
}

