package Practico_5;

import java.util.concurrent.Semaphore;

public class Tren {

	private int capacidad;
	private int cantPasajeros;
	private int cantEsperando;
	private Semaphore subir;
	private Semaphore viajando;
	private Semaphore bajar;
	private Semaphore vender;
	private Semaphore terminal;
	private Semaphore mutex;
	private Semaphore comprar;
	
	public Tren(int unaCapacidad) {
		this.capacidad=unaCapacidad;
		this.cantPasajeros=0;
		this.cantEsperando=0;
		
		this.comprar=new Semaphore(this.capacidad);
		this.subir=new Semaphore(0);
		this.viajando=new Semaphore(0);
		this.bajar=new Semaphore(0);
		this.vender=new Semaphore(0);		
		this.mutex=new Semaphore(1);
		this.terminal=new Semaphore(0);
		
	}

	public void comprarTicket() {
		try {
			this.mutex.acquire();
			this.cantEsperando++;
			this.mutex.release();
			
			this.comprar.acquire();
			this.mutex.acquire();
			
			if (this.cantPasajeros<this.capacidad) {
				System.out.println(Thread.currentThread().getName()+"..............COMPRA TICKET");
				this.vender.release();
				this.cantPasajeros++;
				this.cantEsperando--;
			}			

			this.mutex.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
	public void venderTicket() {
		try {	
			this.vender.acquire();
			System.out.println(Thread.currentThread().getName()+"================VENDE TICKET");
			this.subir.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void subirTren() {
		try {
			this.subir.acquire();
			System.out.println(Thread.currentThread().getName()+"............................sube al TREN");			
			this.viajando.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void iniciarViaje() {
		try {
			this.viajando.acquire(this.capacidad);
			System.out.println(Thread.currentThread().getName()+"..............................................INICIA VIAJE");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void terminaViaje() {
		System.out.println(Thread.currentThread().getName()+"....................termino el viaje");
		this.bajar.release(this.capacidad);
	}
	
	public void bajar() {
		try {
			this.bajar.acquire();
			System.out.println(Thread.currentThread().getName()+"..baja del tren");
			this.terminal.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void volverTerminal() {
		
		try {
			this.terminal.acquire(this.capacidad);
			this.mutex.acquire();
			System.out.println(".....ESPERANDO: "+this.cantEsperando);
			if (this.cantEsperando>this.capacidad) {
				System.out.println(Thread.currentThread().getName()+".....iniciar VENTAS NUEVAMENTE");
				this.comprar.release(this.capacidad);
				this.cantPasajeros=0;
			}else {
				if (this.cantEsperando>0) {
					System.out.println(Thread.currentThread().getName()+".....iniciar VENTAS NUEVAMENTE");
					this.comprar.release(this.cantEsperando);
					this.cantPasajeros=0;					
				}
			}
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
