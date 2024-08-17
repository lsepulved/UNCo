package Practico_5;

import java.util.concurrent.Semaphore;

public class Pista {

	private int cantAterrizajes;
	private int cantEsperandoAterrizar;
	private int cantEsperandoDespegar;
	private int limite;
	
	private Semaphore aterrizar;
	private Semaphore despegar;
	private Semaphore mutex;
	private Semaphore usarPista;
	
	public Pista(int topeAterrizajes) {
	
		this.cantAterrizajes=0;
		this.cantEsperandoAterrizar=0;
		this.cantEsperandoDespegar=0;
		this.limite=topeAterrizajes;
		this.aterrizar=new Semaphore(1);
		this.despegar=new Semaphore(0);
		this.mutex=new Semaphore(1);
		this.usarPista=new Semaphore(1);
		
	}
	
	public void controlarPista() {
		try {
			this.mutex.acquire();

			if (this.cantAterrizajes<this.limite && this.cantEsperandoAterrizar>this.limite) {
				this.aterrizar.release();				
			}else {
				this.cantAterrizajes=0;
				if (this.cantEsperandoDespegar>0) {
					System.out.println(".....CAMBIO DE TURNO, PUEDEN DESPEGAR");
					this.despegar.release();
				}
			}
			
			this.mutex.release();
	
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void entraAterrizar() {
		try {
			this.mutex.acquire();
			this.cantEsperandoAterrizar++;
			this.mutex.release();
	
			this.aterrizar.acquire();
			System.out.println(Thread.currentThread().getName()+".........tiene permiso para ATERRIZAR");
			this.usarPista.acquire();
			
			this.mutex.acquire();
			System.out.println(Thread.currentThread().getName()+".................................................ATERRIZANDO");
			this.cantAterrizajes++;
			this.cantEsperandoAterrizar--;
			this.mutex.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void saleAterrizar() {
		try {
			this.mutex.acquire();

			System.out.println(Thread.currentThread().getName()+".........ATERRIZO");
			if (this.cantAterrizajes<this.limite && this.cantEsperandoAterrizar>0) {
				this.aterrizar.release();
			}else {
				this.cantAterrizajes=0;
				if (this.cantEsperandoDespegar>0)
					this.despegar.release();
				else {
					if (this.cantEsperandoAterrizar>0) {
						this.aterrizar.release();	
					}					
				}
			}
			
			this.usarPista.release();
			this.mutex.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void entraDespegar() {
		try {
			this.mutex.acquire();
			this.cantEsperandoDespegar++;
			this.mutex.release();
	
			this.despegar.acquire();
			System.out.println(Thread.currentThread().getName()+".........tiene permiso para DESPEGAR");
			this.usarPista.acquire();
			
			this.mutex.acquire();
			System.out.println(Thread.currentThread().getName()+".................................................DESPEGANDO");
			this.cantEsperandoDespegar--;
			this.mutex.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void saleDespegar() {
		try {
			this.mutex.acquire();

			System.out.println(Thread.currentThread().getName()+".........DESPEGO");
			if (this.cantEsperandoAterrizar>0) {
				this.aterrizar.release();
			}else {
				if (this.cantEsperandoDespegar>0)
					this.despegar.release();
				else {
					this.aterrizar.release();
				}
			}
			
			this.usarPista.release();
			this.mutex.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
