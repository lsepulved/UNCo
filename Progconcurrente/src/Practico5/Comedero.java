package Practico5;

import java.util.concurrent.Semaphore;

public class Comedero {

	int capacidad=0;
	int cantPerros=0;
	int cantGatos=0;
	int cantEspecie;
	int limite=0;
	Semaphore comer;
	Semaphore entrar;
	Semaphore mutex;
	String turno;
	
	
	public Comedero(int unaCapacidad, int unaCantPerros, int unaCantGatos, int unLimite) {		
		this.capacidad=unaCapacidad;
		this.cantPerros=unaCantPerros;
		this.cantGatos=unaCantGatos;
		this.limite=unLimite;
		this.cantEspecie=0;
		this.comer=new Semaphore(unaCapacidad);
		this.entrar=new Semaphore(1);
		this.mutex=new Semaphore(1);
		this.turno="";
	}

	public boolean entrar(String especie) {
		boolean exito=false;
		
		if (this.turno=="" || this.turno==especie){
			if (this.entrar.tryAcquire()) {
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
		}
							
		return exito;		
	}
	
//	public boolean entrar(String especie) {
//		boolean exito=false;
//		
//			if (this.entrar.tryAcquire(1)) {
//				try {
//					this.mutex.acquire();		
//					
//					this.turno=especie;												
//					System.out.println("Turno de la especie: "+especie);
//					exito=true;
//					
//					this.mutex.release();					
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//							
//		return exito;		
//	}

	public boolean comer() {
		boolean exito=false;
								
		if (this.comer.tryAcquire()) {
			this.cantEspecie++;
			
			if (this.turno=="Perros") {
				this.cantPerros--;
			}else {
				this.cantGatos--;
			}
			
			if (this.cantEspecie>2) {
				if (this.turno=="Perros" && this.cantGatos>0) {
					this.turno="Gatos";
				}else {					
					if (this.turno=="Gatos" && this.cantPerros>0) {
						this.turno="Perros";
					}
				}
				System.out.println("===============Cambia a especie "+this.turno);
				this.cantEspecie=0;
			}
			
			exito=true;
		}
		
		return exito;
	}

	
//	public boolean comer() {
//		boolean exito=false;
//					
//		try {			
//			if (this.comer.availablePermits()==0) {
//				this.turno="";
//			}else {
//				this.comer.acquire();
//				exito=true;
//			}
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return exito;
//	}

	public synchronized void dejarComer(){
		
		this.comer.release();
		
		if (this.comer.availablePermits()==this.capacidad) {			
//			this.turno="";
			this.entrar.release();
		}					
}
	
//	public void dejarComer(){
//		
//			this.comer.release();
//
//			if (this.comer.availablePermits()==this.capacidad) {
//				this.turno="";
//				this.entrar.release();
//			}					
//	}
	
	public synchronized String getTurno() {		
		return this.turno;
	}
}
