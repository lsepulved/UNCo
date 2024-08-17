package Practico4;

import java.util.concurrent.Semaphore;

public class Taxi {

	private Semaphore disponible;
	private Semaphore viajando;
	private Semaphore destino;
	private Semaphore base;
	
	public Taxi() {
		this.disponible=new Semaphore(0);
		this.viajando=new Semaphore(0);
		this.destino=new Semaphore(0);
		this.base=new Semaphore(0);
	}
	
	//taxista
	public void durmiendoEnBase() {
		System.out.println(Thread.currentThread().getName() + " durmiendo mientras espera pasajero");
		this.disponible.release();
	}
	
	//pasajero
	public void tomar() {
		try {			
			this.disponible.acquire();
			System.out.println(Thread.currentThread().getName()+ " Despierto al Taxista");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//pasajero
	public void iniciarViaje() {
		System.out.println(Thread.currentThread().getName()+ " Viajando.....");		
		this.viajando.release();
	}
	
	//taxista
	public void conduciendo() {
		try {						
			this.viajando.acquire();
			System.out.println(Thread.currentThread().getName() + " conduce a destino");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//taxista
	public void llegoAdestino() {
		System.out.println(Thread.currentThread().getName() + " llega a destino");
		this.destino.release();
	}
	
	//pasajero	
	public void terminarViaje() {
		try {			
			this.destino.acquire();
			System.out.println(Thread.currentThread().getName()+ " Viaje terminado");
			this.base.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//taxista
	public void volverAbase() {
		try {			
			this.base.acquire();
			System.out.println(Thread.currentThread().getName()+ " volviendo a la base");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
