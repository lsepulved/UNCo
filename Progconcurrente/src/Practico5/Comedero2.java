package Practico5;

import java.util.concurrent.Semaphore;

public class Comedero2 {

	int capacidad=0;
	Semaphore comer;
	Semaphore entrar;
	Semaphore mutex;
	String turno;
	
	
	public Comedero2(int unaCapacidad) {
		this.capacidad=unaCapacidad;
		this.comer=new Semaphore(unaCapacidad);
		this.entrar=new Semaphore(1);
		this.mutex=new Semaphore(1);
		this.turno="";
	}
	
	public boolean entrar(String especie) {
		boolean exito=false;
		
			if (this.entrar.tryAcquire(1)) {
				try {
					this.mutex.acquire();		
					
					this.turno=especie;												
					System.out.println("Turno de la especie: "+especie);
					exito=true;
					
					this.mutex.release();					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
							
		return exito;		
	}


	public boolean comer(int permisos) {
		boolean exito=false;
					
		try {			
			if (this.comer.availablePermits()<permisos) {
				this.turno="";
			}else {
				this.comer.acquire(permisos);
				exito=true;
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exito;
	}

	public void dejarComer(int permisos){
		
			this.comer.release(permisos);

			if (this.comer.availablePermits()==this.capacidad) {
				this.turno="";
				this.entrar.release();
			}					
	}
	
	public String getTurno() {
		return this.turno;
	}
}
